package io.dailydev.r3vl.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import io.dailydev.r3vl.api.model.Party;

@Transactional
public interface PartyRepository extends CrudRepository<Party, Long> {
	
	public Party findBypartyName(String partyName);
	
}
