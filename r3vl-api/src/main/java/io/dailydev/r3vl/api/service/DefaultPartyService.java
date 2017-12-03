package io.dailydev.r3vl.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Party;
import io.dailydev.r3vl.api.model.Play;
import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.model.SongStatus;
import io.dailydev.r3vl.api.repository.PartyRepository;

@Component
public class DefaultPartyService implements PartyService {

	@Autowired
	PartyRepository partyRepository;
	
	@Autowired
	PlayService playService;
	
	@Autowired
	SongService songService;
	
	@Override
	public Party find(Long id) {
		return partyRepository.findOne(id);
	}
	
	@Override
	public List<Party> findAllParties() {
		return (List<Party>) partyRepository.findAll();
	}

	@Override
	public Party createParty(Party party) {
		return partyRepository.save(party);
	}

	@Override
	public void deleteParty(Long id) {
		partyRepository.delete(id);
	}

	@Override
	public void addSongToParty(Song song, Long partyId) {
		Song existingSong = songService.findByVideoId(song.getVideoId());
		Party party = this.find(partyId);
		
		Play play = new Play();
		play.setParty(party);
		play.setStatus(SongStatus.ADDED);
		
		if(existingSong == null) {
			// create the song
			play.setSong(song);
			songService.createSong(song);
		} else {
			// update the song
			play.setSong(existingSong);
		}
		
		playService.createPlay(play);		
	}

	@Override
	public List<Play> findAllPlaysByParty(Long partyId) {
		return playService.findAllPlaysByPartyId(partyId);
	}

	@Override
	public Play findNextSongByParty(Long partyId) {
		
		ArrayList<Play> playList = (ArrayList<Play>) playService.findAllPlaysByPartyIdWhereStatusIdAddedOrderById(this.find(partyId));
		
		Play play = playList.get(0);
		play.setStatus(SongStatus.PLAYED);
		playService.updatePlay(play);	
		
		return play;
	}
	
	

}
