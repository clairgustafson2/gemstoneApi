package com.clairgustafson.gemstoneApi.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clairgustafson.gemstoneApi.entity.Collection;
import com.clairgustafson.gemstoneApi.entity.Collector;
import com.clairgustafson.gemstoneApi.entity.Gemstone;
import com.clairgustafson.gemstoneApi.repository.CollectionRepo;
import com.clairgustafson.gemstoneApi.repository.CollectorRepo;
import com.clairgustafson.gemstoneApi.repository.GemstoneRepo;

@Service
public class CollectionService {
	private static final Logger logger = LogManager.getLogger(CollectorService.class);
	
	@Autowired
	private CollectionRepo repo;
	
	@Autowired
	private GemstoneRepo gemstoneRepo;
	
	@Autowired
	private CollectorRepo collectorRepo;
	

	//Create a collection
	public Collection newCollection(Set<Long> gemstoneIds, Long collectorId) throws Exception {
		try {
			Collector collector = collectorRepo.findById(collectorId).orElseThrow();
			Collection collection = initializeNew(gemstoneIds, collector);
			return repo.save(collection);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to create new collection for collector: " + collectorId, e);
			throw e;
		}
	}
	
	private Collection initializeNew(Set<Long> gemstoneIds, Collector collector) {
		Collection collection = new Collection();
		collection.setGemstones(convertToGemstoneSet(gemstoneRepo.findAllById(gemstoneIds)));
		collection.setCreated(LocalDate.now());
		collection.setCollector(collector);
		addCollectionToGemstones(collection);
		return collection;
	}
	
	private void addCollectionToGemstones(Collection collection) {
		Set<Gemstone> gemstones = collection.getGemstones();
		for (Gemstone gemstone : gemstones) {
			gemstone.getCollection().add(collection);
		}
		
	}

	private Set<Gemstone> convertToGemstoneSet(Iterable<Gemstone> iterable) {
		Set<Gemstone> set = new HashSet<Gemstone>();
		for (Gemstone gemstone : iterable) {
			set.add(gemstone);
		}
		return set;
	}

	
	//Get a collection by id
	public Collection getCollectionById(Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve collection: " + id, e);
			throw e;
		}
	}

}
