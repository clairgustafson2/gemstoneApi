package com.clairgustafson.gemstoneApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clairgustafson.gemstoneApi.entity.Gemstone;
import com.clairgustafson.gemstoneApi.repository.GemstoneRepo;

@Service
public class GemstoneService {

	private static final Logger logger = LogManager.getLogger(GemstoneService.class);
	
	@Autowired
	private GemstoneRepo repo;

	
	//Create a gemstone
	public Gemstone createGemstone(Gemstone gemstone) {
		return repo.save(gemstone);
	}

	//Get all gemstones
	public Iterable<Gemstone> getGemstones() {
		return repo.findAll();
	}

	//Update a gemstone by id
	public Gemstone updateGemstone(Gemstone gemstone, Long id) throws Exception {
		try {
			Gemstone oldGemstone = repo.findById(id).orElseThrow();
			oldGemstone.setName(gemstone.getName());
			oldGemstone.setScale(gemstone.getScale());
			oldGemstone.setProperties(gemstone.getProperties());
			return repo.save(oldGemstone);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update gemstone" + id, e);
			throw new Exception("Unable to update gemstone");
		}
	}

	//Delete gemstone by id
	public void deleteGemstone(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete gemstone:" + id, e);
			throw new Exception("Unable to delete gemstone.");
		}
	}

	//Update picture by id
	public Gemstone updatePicture(Long gemstoneId, String url) throws Exception {
		Gemstone gemstone = repo.findById(gemstoneId).orElseThrow();
		if (gemstone == null) {
			throw new Exception("User does not exist.");
		}
		gemstone.setPictureUrl(url);
		return repo.save(gemstone);
	}

}
