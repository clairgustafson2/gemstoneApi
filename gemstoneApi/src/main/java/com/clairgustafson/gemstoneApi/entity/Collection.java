package com.clairgustafson.gemstoneApi.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Collection {
	
	private Long id;
	private LocalDate created;
	private Set<Gemstone> gemstones;
	
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

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	@ManyToMany(mappedBy = "collection")
	public Set<Gemstone> getGemstones() {
		return gemstones;
	}

	public void setGemstones(Set<Gemstone> gemstones) {
		this.gemstones = gemstones;
	}

	@ManyToOne
	@JoinColumn(name = "collectorId")
	public Collector getCollector() {
		return collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	

}
