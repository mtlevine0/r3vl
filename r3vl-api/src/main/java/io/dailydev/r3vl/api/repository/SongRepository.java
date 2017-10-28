package io.dailydev.r3vl.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import io.dailydev.r3vl.api.model.Song;

@Transactional
public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAllByPartyId(Long partyId); 
	
	Song findByVideoId(String videoId);
	
}
