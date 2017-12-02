package io.dailydev.r3vl.api.service;

import java.util.List;
import java.util.Set;

import io.dailydev.r3vl.api.model.Song;

public interface SongService {
	
	public Song find(Long id);
	
	public List<Song> findAllSongs();
	
	public Song createSong(Song song);
	
	public Song markSongAvailable(String videoId);
	
	public Song updateSong(Song song);
	
	public void deleteSong(Long id);
	
	public Song findByVideoId(String videoId);
	
	public Set<Song> findAllSongsByParty(Long partyId);

}
