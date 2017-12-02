package io.dailydev.r3vl.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Party;
import io.dailydev.r3vl.api.model.Song;

@Component
public interface PartyService {
	
	public List<Party> findAllParties();
	
	public Party createParty(Party party);
	
	public void deleteParty(Long id);

	public Party find(Long id);
	
}
