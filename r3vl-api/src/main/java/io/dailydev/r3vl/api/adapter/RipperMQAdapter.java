package io.dailydev.r3vl.api.adapter;

import java.net.ConnectException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.dailydev.r3vl.api.model.Song;

@Component
public class RipperMQAdapter {
	
	@Value("${rippermq.uri}")
	private String ripperMQuri;
	
	public void addSong(Song song) throws ConnectException {
		// TODO: Add logic for handling queue full scenario.
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject( ripperMQuri, song, Song.class);
	}

}
