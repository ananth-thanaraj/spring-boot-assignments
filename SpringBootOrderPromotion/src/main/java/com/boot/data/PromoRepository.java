package com.boot.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.model.Promotions;

public interface PromoRepository extends MongoRepository<Promotions, String>{

}
