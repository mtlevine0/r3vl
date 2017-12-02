package io.dailydev.r3vl.api.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import io.dailydev.r3vl.api.model.Play;

@Transactional
public interface PlayRepository extends CrudRepository<Play, Long> { 

	List<Play> findAllByPartyId(Long partyId); 

}
