package com.clairgustafson.gemstoneApi.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clairgustafson.gemstoneApi.entity.Gemstone;
import com.clairgustafson.gemstoneApi.service.GemstoneService;

@RestController
@RequestMapping("/gemstones")
public class GemstoneController {
	
	private static String UPLOADED_FOLDER = "./pictures/";
	
	@Autowired
	private GemstoneService service;
	
	//Create gemstone
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createGemstone(@RequestBody Gemstone gemstone) {
		return new ResponseEntity<Object>(service.createGemstone(gemstone), HttpStatus.CREATED);
	}
			
			
	//Get gemstones
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getGemstones(){
		return new ResponseEntity<Object>(service.getGemstones(), HttpStatus.OK);
	}
			
			
	//Update gemstone by id
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateGemstone(@RequestBody Gemstone gemstone, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateGemstone(gemstone, id), HttpStatus.OK);
		} catch (Exception e) {
					return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
			
	//Delete collector by id
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteGemstone(@PathVariable Long id) {
		try {
			service.deleteGemstone(id);
			return new ResponseEntity<Object>("Successfully deleted gemstone with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
			}
		}
	
	//Update gemstone picture
	@RequestMapping(value="/{id}/picture", method= RequestMethod.POST)
	public ResponseEntity<Object> singleFileUpload(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return new ResponseEntity<Object>("Please upload a file.", HttpStatus.BAD_REQUEST);
		}
		
		try {
			String url = UPLOADED_FOLDER + file.getOriginalFilename();
			byte[] bytes = file.getBytes();
			Path path = Paths.get(url);
			Files.write(path, bytes);
			return new ResponseEntity<Object>(service.updatePicture(id, url), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
