package com.clairgustafson.gemstoneApi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.clairgustafson.gemstoneApi.util.Rarity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Gemstone {
	
	private Long id;
	private String name;
	private Rarity scale;
	private String pictureUrl;
	private Properties properties;
	
	@JsonIgnore
	private Set<Collection> collection;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rarity getScale() {
		return scale;
	}

	public void setScale(Rarity scale) {
		this.scale = scale;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "gemstone_collection",
			joinColumns = @JoinColumn(name = "collectionId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "gemstoneId", referencedColumnName = "id"))
	public Set<Collection> getCollection() {
		return collection;
	}

	public void setCollection(Set<Collection> collection) {
		this.collection = collection;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
