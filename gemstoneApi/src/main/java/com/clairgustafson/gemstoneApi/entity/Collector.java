package com.clairgustafson.gemstoneApi.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Collector {
	
	private Long id;
	private  String firstName;
	private String lastName;
	private String email;
	private Bio bio;
	private Set<Collection> collection;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	public Bio getBio() {
		return bio;
	}
	
	public void setBio(Bio bio) {
		this.bio = bio;
	}
	
	@OneToMany(mappedBy = "collector")
	public Set<Collection> getCollection() {
		return collection;
	}
	
	public void setCollection(Set<Collection> collection) {
		this.collection = collection;
	}
	
	

}
