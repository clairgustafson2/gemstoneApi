package com.clairgustafson.gemstoneApi.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import com.clairgustafson.gemstoneApi.entity.Bio;
import com.clairgustafson.gemstoneApi.entity.Collector;
import com.clairgustafson.gemstoneApi.repository.BioRepo;


@Service
public class BioService {
	
private static final Logger logger = LogManager.getLogger(CollectorService.class);
	
	@Autowired
	private BioRepo repo;

	//Create
	public Bio createBio(Bio bio) {
		return repo.save(bio);
	}

	
	//Get
	public Bio getBioById(Long id) throws Exception {
		try {
			return repo.findById(id).orElseThrow();
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve bio: " + id, e);
			throw e;
		}
	}

	//Update
	public Bio updateBio(Bio bio, Long id) throws Exception {
		try {
			Bio oldBio = repo.findById(id).orElseThrow();
			oldBio.setState(bio.getState());
			oldBio.setFirstStone(bio.getFirstStone());
			oldBio.setFavoriteStone(bio.getFavoriteStone());
			oldBio.setAboutMe(bio.getAboutMe());
			return repo.save(oldBio);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update bio: " + id, e);
			throw new Exception("Unable to update bio.");
		}
	}

	//Delete by id
	public void deleteBio(Long id) throws Exception {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete bio: " + id, e);
			throw new Exception("Unable to delete bio.");
		}
	}

}
