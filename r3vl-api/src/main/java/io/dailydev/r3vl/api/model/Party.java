package io.dailydev.r3vl.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Party {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String partyName;
	
	@JsonBackReference
	@OneToMany(
		mappedBy="party", 
		cascade = CascadeType.ALL, 
		orphanRemoval = true
	)
	private List<Song> songQueue = new ArrayList<Song>();
	
	public Party() { }

	public Party(Long id, String partyName, List<Song> songQueue) {
		super();
		this.id = id;
		this.partyName = partyName;
		this.songQueue = songQueue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public List<Song> getSongQueue() {
		return songQueue;
	}

	public void setSongQueue(List<Song> songQueue) {
		this.songQueue = songQueue;
	}

}
