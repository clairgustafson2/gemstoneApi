package com.clairgustafson.gemstoneApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.gemstoneApi.entity.Collector;

public interface CollectorRepo extends CrudRepository  <Collector, Long>{

}