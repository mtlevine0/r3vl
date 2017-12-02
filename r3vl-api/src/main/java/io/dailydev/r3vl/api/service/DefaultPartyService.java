package io.dailydev.r3vl.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Party;
import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.repository.PartyRepository;

@Component
public class DefaultPartyService implements PartyService {

	@Autowired
	PartyRepository partyRepository;
	
	@Override
	public Party find(Long id) {
		return partyRepository.findOne(id);
	}
	
	@Override
	public List<Party> findAllParties() {
		return (List<Party>) partyRepository.findAll();
	}

	@Override
	public Party createParty(Party party) {
		return partyRepository.save(party);
	}

	@Override
	public void deleteParty(Long id) {
		partyRepository.delete(id);
	}

}
