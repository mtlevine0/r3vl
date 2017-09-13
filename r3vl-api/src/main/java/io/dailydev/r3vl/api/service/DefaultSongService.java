package io.dailydev.r3vl.api.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.repository.SongRepository;

@Component
public class DefaultSongService implements SongService {

	@Autowired
	SongRepository songRepository;
	
	@Override
	public List<Song> findAll() {
		return (List<Song>) songRepository.findAll();
	}

	@Override
	public Song create(Song song) {
		return songRepository.save(song);
	}

	@Override
	public void delete(Long id) {
		songRepository.delete(id);
	}

	@Override
	public List<Song> findAllByPartyId(Long partyId) {
		return songRepository.findAllByPartyId(partyId);
	}

}
