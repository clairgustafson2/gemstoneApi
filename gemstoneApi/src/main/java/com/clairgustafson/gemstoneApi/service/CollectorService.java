package com.clairgustafson.gemstoneApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clairgustafson.gemstoneApi.entity.Collector;
import com.clairgustafson.gemstoneApi.repository.CollectorRepo;

@Service
public class CollectorService {
	
private static final Logger logger = LogManager.getLogger(CollectorService.class);
	
	@Autowired
	private CollectorRepo repo;

	
	//Get a collector by id
	public Collector getCollectorById(Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve collector: " + id, e);
			throw e;
		}
	}
	
	//Create
	public Collector createCollector(Collector collector) {
		return repo.save(collector);
	}


	//Update collector by id
	public Collector updateCollector(Collector collector, Long id) throws Exception {
		try {
			Collector oldCollector = repo.findById(id).orElseThrow();
			oldCollector.setFirstName(collector.getFirstName());
			oldCollector.setLastName(collector.getLastName());
			oldCollector.setEmail(collector.getEmail());
			oldCollector.setBio(collector.getBio());
		return repo.save(oldCollector);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update customer: " + id, e);
			throw new Exception("Unable to update customer.");
		}
	}

	
	//Delete collector by id
	public void deleteCollector(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete collector: " + id, e);
			throw new Exception("Unable to delete collector.");
		}
	}
}
	
