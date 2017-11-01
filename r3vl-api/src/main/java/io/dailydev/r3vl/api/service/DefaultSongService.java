package io.dailydev.r3vl.api.service;

import java.net.ConnectException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.adapter.RipperMQAdapter;
import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.model.SongStatus;
import io.dailydev.r3vl.api.repository.SongRepository;

@Component
public class DefaultSongService implements SongService {

	@Autowired
	SongRepository songRepository;
	
	@Autowired
	RipperMQAdapter ripperMQAdapter;
	
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
		try {
			ripperMQAdapter.addSong(song);
			song.setStatus(SongStatus.QUEUED);
		} catch(ConnectException ce) {
			song.setStatus(SongStatus.FAILED);
		}
		return songRepository.save(song);
	}

	@Override
	public Song status(String videoId) {
		Song song = this.findByVideoId(videoId);
		song.setStatus(SongStatus.AVAILABLE);
		this.update(song);
		return song;
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
