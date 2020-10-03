package com.clairgustafson.gemstoneApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bio {
	
	private Long id;
	private String state;
	private String firstStone;
	private String favoriteStone;
	private String aboutMe;
	
	@JsonIgnore
	private Collector collector;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getFirstStone() {
		return firstStone;
	}


	public void setFirstStone(String firstStone) {
		this.firstStone = firstStone;
	}


	public String getFavoriteStone() {
		return favoriteStone;
	}


	public void setFavoriteStone(String favoriteStone) {
		this.favoriteStone = favoriteStone;
	}


	public String getAboutMe() {
		return aboutMe;
	}


	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	@OneToOne(mappedBy = "bio")
	public Collector getCollector() {
		return collector;
	}


	public void setCollector(Collector collector) {
		this.collector = collector;
	}


}
