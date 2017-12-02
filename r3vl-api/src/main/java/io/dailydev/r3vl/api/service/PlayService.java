package io.dailydev.r3vl.api.service;

import java.util.List;

import io.dailydev.r3vl.api.model.Play;

public interface PlayService {
	
	public List<Play> findAllPlaysByPartyId(Long partyId);
	
	public Play createPlay(Play play);
	
	public void deletePlay(Long id);

	public Play findPlay(Long id);

}
