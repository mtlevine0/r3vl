package io.dailydev.r3vl.api.service;

import java.util.List;
import java.util.Set;

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
	public List<Song> findAllSongs() {
		return (List<Song>) songRepository.findAll();
	}

	@Override
	public Song createSong(Song song) {
		try {
			ripperMQAdapter.addSong(song);
			song.setStatus(SongStatus.QUEUED);
		} catch(Exception e) {
			song.setStatus(SongStatus.FAILED);
		}
		return songRepository.save(song);
	}

	@Override
	public Song markSongAvailable(String videoId) {
		Song song = this.findByVideoId(videoId);
		song.setStatus(SongStatus.AVAILABLE);
		this.updateSong(song);
		return song;
	}
	
	@Override
	public Song updateSong(Song song) {
		return songRepository.save(song);
	}

	@Override
	public void deleteSong(Long id) {
		songRepository.delete(id);
	}

	@Override
	public Song findByVideoId(String videoId) {
		return songRepository.findByVideoId(videoId);
	}
	
	@Override
	public Set<Song> findAllSongsByParty(Long partyId) {
		return null;
	}


}
