package com.clairgustafson.gemstoneApi.service;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.clairgustafson.gemstoneApi.entity.Bio;
import com.clairgustafson.gemstoneApi.entity.Collection;
import com.clairgustafson.gemstoneApi.repository.CollectionRepo;
import com.clairgustafson.gemstoneApi.repository.GemstoneRepo;

@Service
public class CollectionService {
	private static final Logger logger = LogManager.getLogger(CollectorService.class);
	
	@Autowired
	private CollectionRepo repo;
	
	@Autowired
	private GemstoneRepo gemstoneRepo;
	

	//Create a collection
	public MultiValueMap<String, String> createCollection(Set<Long> gemstoneIds, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	//Get a collection by id
	public Collection getCollection(Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve collection: " + id, e);
			throw e;
		}
	}

	//Update collection
	public MultiValueMap<String, String> updateCollection(Collection collection, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
