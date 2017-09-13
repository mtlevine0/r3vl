package io.dailydev.r3vl.api.resource;

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
import io.dailydev.r3vl.api.service.PartyService;

@RestController
@RequestMapping("/api/v1/")
public class PartyResource {
	
	@Autowired
	PartyService partyService;

	@RequestMapping(value = "party", method = RequestMethod.GET)
	public ResponseEntity<List<Party>> findAll() {
		return new ResponseEntity<List<Party>>(partyService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "party", method = RequestMethod.POST)
	public ResponseEntity<Party> create(@RequestBody Party party) {
		return new ResponseEntity<Party>(partyService.create(party), HttpStatus.OK);
	}
	
	@RequestMapping(value = "party/{id}", method = RequestMethod.DELETE)
	public ResponseEntity delete(@PathVariable("id") Long id) {
		partyService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
