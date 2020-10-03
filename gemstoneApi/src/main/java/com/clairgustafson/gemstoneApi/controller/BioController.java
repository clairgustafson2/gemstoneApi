package com.clairgustafson.gemstoneApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clairgustafson.gemstoneApi.entity.Bio;
import com.clairgustafson.gemstoneApi.service.BioService;

@RestController
@RequestMapping("collectors/{id}/bios")
public class BioController {
	
	@Autowired
	private BioService service;
	
	
	//Create bio
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createBio(@RequestBody Bio bio){
		return new ResponseEntity<Object>(service.createBio(bio), HttpStatus.CREATED);
	}
	
	
	//Get bio by id
	@RequestMapping(value="/{id}", method= RequestMethod.GET)
	public ResponseEntity<Object> getBio(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object> (service.getBioById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	//Update bio
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateBio(@RequestBody Bio bio, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateBio(bio, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//Delete bio by id
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteBio(@PathVariable Long id) {
		try {
			service.deleteBio(id);
			return new ResponseEntity<Object>("Successfully deleted bio with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
