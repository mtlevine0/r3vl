package io.dailydev.r3vl.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@JsonInclude(Include.NON_NULL)
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	private String videoId;
	private String title;
	private String artist;
	private int duration;
	private SongStatus status;
	private String host;
	
	@OneToMany(mappedBy = "song", cascade = CascadeType.ALL)
	private Set<Play> playList = new HashSet<Play>();
	
	public Song() { }

	public Song(Long id, String videoId, String title, String artist, int duration, SongStatus status, String host,
			Set<Play> playList) {
		super();
		this.id = id;
		this.videoId = videoId;
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.status = status;
		this.host = host;
		this.playList = playList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public SongStatus getStatus() {
		return status;
	}

	public void setStatus(SongStatus status) {
		this.status = status;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Set<Play> getPlayList() {
		return playList;
	}

	public void setPlayList(Set<Play> playList) {
		this.playList = playList;
	}

}
