package io.dailydev.r3vl.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Party;

@Component
public interface PartyService {
	
	public List<Party> findAll();
	
	public Party create(Party party);
	
	public void delete(Long id);
	
}
