package com.clairgustafson.gemstoneApi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Properties {
	
	private Long id;
	private String color;
	private String chemicalEquation;
	private String meltingPoint;
	private String fact;
	
	@JsonIgnore
	private Gemstone gemstone;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getChemicalEquation() {
		return chemicalEquation;
	}

	public void setChemicalEquation(String chemicalEquation) {
		this.chemicalEquation = chemicalEquation;
	}

	public String getMeltingPoint() {
		return meltingPoint;
	}

	public void setMeltingPoint(String meltingPoint) {
		this.meltingPoint = meltingPoint;
	}

	public String getFact() {
		return fact;
	}

	public void setFact(String fact) {
		this.fact = fact;
	}

	@OneToOne(mappedBy = "properties")
	public Gemstone getGemstone() {
		return gemstone;
	}

	public void setGemstone(Gemstone gemstone) {
		this.gemstone = gemstone;
	}
	
	

}
