package io.dailydev.r3vl.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.repository.SongRepository;

@Component
public class DefaultSongService implements SongService {

	@Autowired
	SongRepository songRepository;
	
	@Override
	public Song find(Long id) {
		return songRepository.findOne(id);
	}
	
	@Override
	public List<Song> findAll() {
		return (List<Song>) songRepository.findAll();
	}

	@Override
	public Song create(Song song) {
		// add the song to rippernode
		final String uri = "http://172.17.0.1:8081/api/v1/song";
		RestTemplate restTemplate = new RestTemplate();
	    Song result = restTemplate.postForObject( uri, song, Song.class);
	    System.out.println("DefaultSongService: " + result.getVideoId());
	    
		return songRepository.save(song);
	}
	
	@Override
	public Song update(Song song) {
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

	@Override
	public Song findByVideoId(String videoId) {
		return songRepository.findByVideoId(videoId);
	}

}
