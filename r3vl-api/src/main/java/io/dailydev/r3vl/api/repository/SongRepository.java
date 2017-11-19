package io.dailydev.r3vl.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.model.SongStatus;


@Transactional
public interface SongRepository extends CrudRepository<Song, Long> {

	List<Song> findAllByPartyId(Long partyId); 
	
	Song findByVideoId(String videoId);
	
	@Query("select s from Song s where status=io.dailydev.r3vl.api.model.SongStatus.AVAILABLE order by id")
	List<Song> findByOrderByIdAsc();
	
}
