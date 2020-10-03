package com.clairgustafson.gemstoneApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clairgustafson.gemstoneApi.entity.Collector;
import com.clairgustafson.gemstoneApi.service.CollectorService;

@RestController
@RequestMapping("/collectors")
public class CollectorController {
	
	@Autowired
	private CollectorService service;
	
		//Create collector
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Object> createCollector(@RequestBody Collector collector){
			return new ResponseEntity<Object>(service.createCollector(collector), HttpStatus.CREATED);
		}
		
		
		//Get Collector by id
		@RequestMapping(value="/{id}", method= RequestMethod.GET)
		public ResponseEntity<Object> getCollector(@PathVariable Long id) {
			try {
				return new ResponseEntity<Object> (service.getCollectorById(id), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
		
		
		//Update collector
		@RequestMapping(value="/{id}", method=RequestMethod.PUT)
		public ResponseEntity<Object> updateCollector(@RequestBody Collector collector, @PathVariable Long id) {
			try {
				return new ResponseEntity<Object>(service.updateCollector(collector, id), HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
		
		//Delete collector by id
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public ResponseEntity<Object> deleteCollector(@PathVariable Long id) {
			try {
				service.deleteCollector(id);
				return new ResponseEntity<Object>("Successfully deleted collector with id: " + id, HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}


}
