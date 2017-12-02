package io.dailydev.r3vl.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.dailydev.r3vl.api.model.Song;
import io.dailydev.r3vl.api.service.SongService;

@RestController
@RequestMapping("/api/v1/")
public class SongResource {
	
	@Autowired
	SongService songService;
	
	@RequestMapping(value = "song", method = RequestMethod.GET)
	public ResponseEntity<List<Song>> findAllSongs() {
		return new ResponseEntity<List<Song>>(songService.findAllSongs(), HttpStatus.OK);
	}

	@RequestMapping(value = "song/{videoId}", method = RequestMethod.PUT)
	public  ResponseEntity<Song> markSongAvailable(@PathVariable("videoId") String videoId) {
		return new ResponseEntity<Song>(songService.markSongAvailable(videoId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "song/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<HttpStatus> deleteSong(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
