package io.dailydev.r3vl.api.service;

import java.util.List;
import java.util.Set;

import io.dailydev.r3vl.api.model.Song;

public interface SongService {
	
	public List<Song> findAll();
	
	public Song create(Song song);
	
	public void delete(Long id);

	public List<Song> findAllByPartyId(Long partyId);

}
