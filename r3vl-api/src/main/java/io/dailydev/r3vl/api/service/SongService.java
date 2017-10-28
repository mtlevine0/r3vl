package io.dailydev.r3vl.api.service;

import java.util.List;
import java.util.Set;

import io.dailydev.r3vl.api.model.Song;

public interface SongService {
	
	public Song find(Long id);
	
	public List<Song> findAll();
	
	public Song create(Song song);
	
	public Song update(Song song);
	
	public void delete(Long id);

	public List<Song> findAllByPartyId(Long partyId);

}