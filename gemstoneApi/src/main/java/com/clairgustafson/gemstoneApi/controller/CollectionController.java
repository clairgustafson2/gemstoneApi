package com.clairgustafson.gemstoneApi.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clairgustafson.gemstoneApi.entity.Collection;
import com.clairgustafson.gemstoneApi.service.CollectionService;

@RestController
@RequestMapping("collectors/{id}/collections")
public class CollectionController {
	
	@Autowired
	private CollectionService service;
	
		//Create a collection
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Object> createCollection(@RequestBody Set<Long> gemstoneIds, @PathVariable Long id) {
			return new ResponseEntity<Object>(service.createCollection(gemstoneIds, id), HttpStatus.CREATED);
		}
				
				
		//Get collection
		@RequestMapping(value="/{collectioId}", method= RequestMethod.GET)
		public ResponseEntity<Object> getCollection(@PathVariable Long id) {
			try {
				return new ResponseEntity<Object> (service.getCollectionById(id), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
				
				
		//Update collection by id
		@RequestMapping(value="/{collectionId}", method=RequestMethod.PUT)
		public ResponseEntity<Object> updateCollection(@RequestBody Collection collection, @PathVariable Long id) {
			try {
				return new ResponseEntity<Object>(service.updateCollection(collection, id), HttpStatus.OK);
			} catch (Exception e) {
						return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
				}
			}
}
