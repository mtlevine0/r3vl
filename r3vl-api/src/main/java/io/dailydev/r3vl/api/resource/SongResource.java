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

import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.service.SongService;

@RestController
@RequestMapping("/api/v1/")
public class SongResource {
	
//	@Autowired
//	SongService songService;
//	
//	@RequestMapping(value = "song/{partyId}/next", method = RequestMethod.GET)
//	public ResponseEntity<Song> findNextSongByParty(@PathVariable("partyId") Long partyId) {
//		return new ResponseEntity<Song>(songService.getNextSong(partyId), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "song/{partyId}", method = RequestMethod.GET)
//	public ResponseEntity<List<Song>> findSongsAllByParty(@PathVariable("partyId") Long partyId) {
//		return new ResponseEntity<List<Song>>(songService.findAllSongsByPartyId(partyId), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "song", method = RequestMethod.GET)
//	public ResponseEntity<List<Song>> findAllSongs() {
//		return new ResponseEntity<List<Song>>(songService.findAllSongs(), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "song", method = RequestMethod.POST)
//	public ResponseEntity<Song> createSong(@RequestBody Song song) {
//		HttpStatus status = HttpStatus.OK;
//		song = songService.createSong(song);
//		return new ResponseEntity<Song>(song, status);
//	}
//	
//	@RequestMapping(value = "song/{videoId}", method = RequestMethod.PUT)
//	public  ResponseEntity<Song> markSongAvailable(@PathVariable("videoId") String videoId) {
//		return new ResponseEntity<Song>(songService.markSongAvailable(videoId), HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "song/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<HttpStatus> deleteSong(@PathVariable("id") Long id) {
//		songService.deleteSong(id);
//		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//	}

}
