package io.dailydev.r3vl.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.dailydev.r3vl.api.model.Party;
import io.dailydev.r3vl.api.model.Play;

@Transactional
public interface PlayRepository extends CrudRepository<Play, Long> { 

	List<Play> findAllPlaysByPartyId(Long partyId);
	
	@Query("select p from Play p where "
			+ "p.party=:party and "
			+ "p.status=io.dailydev.r3vl.api.model.SongStatus.ADDED "
			+ "order by id")
	List<Play> findAllPlaysByPartyAndStatusIsAddedOrderById(@Param("party") Party party);

}
