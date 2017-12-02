package io.dailydev.r3vl.api.repository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.dailydev.r3vl.api.model.Song;


@Transactional
public interface SongRepository extends CrudRepository<Song, Long> {
	
	Song findByVideoId(String videoId);
		
	@Query("select s from Song s where status=io.dailydev.r3vl.api.model.SongStatus.AVAILABLE order by id")
	List<Song> findWhereStatusIsAvailableOrderByIdAsc();
	
}
