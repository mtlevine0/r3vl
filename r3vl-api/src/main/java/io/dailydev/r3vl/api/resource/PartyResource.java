package io.dailydev.r3vl.api.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.dailydev.r3vl.api.model.Party;
import io.dailydev.r3vl.api.model.Play;
import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.model.SongStatus;
import io.dailydev.r3vl.api.service.PartyService;
import io.dailydev.r3vl.api.service.PlayService;
import io.dailydev.r3vl.api.service.SongService;

@RestController
@RequestMapping("/api/v1/")
public class PartyResource {
	
	@Autowired
	PartyService partyService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlayService playService;

	@RequestMapping(value = "party", method = RequestMethod.GET)
	public ResponseEntity<List<Party>> findAllParties() {
		return new ResponseEntity<List<Party>>(partyService.findAllParties(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "party", method = RequestMethod.POST)
	public ResponseEntity<Party> createParty(@RequestBody Party party) {
		return new ResponseEntity<Party>(partyService.createParty(party), HttpStatus.OK);
	}
	
	@RequestMapping(value = "party/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteParty(@PathVariable("id") Long id) {
		partyService.deleteParty(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "party/{partyId}/song/next", method = RequestMethod.GET)
	public ResponseEntity<Play> findNextSongByParty(@PathVariable("partyId") Long partyId) {
		
		return new ResponseEntity<Play>(partyService.findNextSongByParty(partyId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "party/{partyId}/play", method = RequestMethod.GET)
	public ResponseEntity<Collection<Play>> findAllPlaysByParty(@PathVariable("partyId") Long partyId) {
				
		return new ResponseEntity<Collection<Play>>(partyService.findAllPlaysByParty(partyId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "party/{partyId}/song", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> addSongToParty(@PathVariable("partyId") Long partyId, @RequestBody Song song) {
		
		partyService.addSongToParty(song, partyId);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
