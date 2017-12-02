package io.dailydev.r3vl.api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Party {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String partyName;
	
	@OneToMany(mappedBy = "party", cascade = CascadeType.ALL)
	private Set<Play> playList = new HashSet<Play>();
	
	public Party() { }

	public Party(Long id, String partyName, Set<Play> playList) {
		super();
		this.id = id;
		this.partyName = partyName;
		this.playList = playList;
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

	public Set<Play> getPlayList() {
		return playList;
	}

	public void setPlayList(Set<Play> playList) {
		this.playList = playList;
	}

}
