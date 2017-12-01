package io.dailydev.r3vl.api.service;

import java.net.ConnectException;
import java.util.List;
import java.util.Set;

import io.dailydev.r3vl.api.model.Song;

public interface SongService {
	
	public Song find(Long id);
	
	public List<Song> findAllSongs();
	
	public Song createSong(Song song);
	
	public Song updateSong(Song song);
	
	public void deleteSong(Long id);

	public List<Song> findAllSongsByPartyId(Long partyId);
	
	public Song findByVideoId(String videoId);

	Song markSongAvailable(String videoId);
	
	Song getNextSong(Long partyId);

}
