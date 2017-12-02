package io.dailydev.r3vl.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.dailydev.r3vl.api.model.Play;
import io.dailydev.r3vl.api.repository.PlayRepository;

@Component
public class DefaultPlayService implements PlayService {
	
	@Autowired
	PlayRepository playRepository;

	@Override
	public List<Play> findAllPlaysByPartyId(Long partyId) {
		return playRepository.findAllByPartyId(partyId);
	}

	@Override
	public Play createPlay(Play play) {
		return playRepository.save(play);
	}

	@Override
	public void deletePlay(Long id) {
		playRepository.delete(id);

	}

	@Override
	public Play findPlay(Long id) {
		return playRepository.findOne(id);
	}

}
