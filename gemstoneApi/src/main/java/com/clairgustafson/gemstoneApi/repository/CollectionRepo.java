package com.clairgustafson.gemstoneApi.repository;

import org.springframework.data.repository.CrudRepository;

import com.clairgustafson.gemstoneApi.entity.Collection;

public interface CollectionRepo extends CrudRepository  <Collection, Long>{

}
