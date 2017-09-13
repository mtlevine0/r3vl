package io.dailydev.r3vl.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Party;
import io.dailydev.r3vl.api.repository.PartyRepository;

@Component
public class DefaultPartyService implements PartyService {

	@Autowired
	PartyRepository partyRepository;
	
	@Override
	public List<Party> findAll() {
		return (List<Party>) partyRepository.findAll();
	}

	@Override
	public Party create(Party party) {
		return partyRepository.save(party);
	}

	@Override
	public void delete(Long id) {
		partyRepository.delete(id);
	}

}
