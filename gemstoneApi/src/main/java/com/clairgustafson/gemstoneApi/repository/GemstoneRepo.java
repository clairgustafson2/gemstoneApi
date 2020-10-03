package com.clairgustafson.gemstoneApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.gemstoneApi.entity.Gemstone;

public interface GemstoneRepo extends CrudRepository  <Gemstone, Long>{

}
