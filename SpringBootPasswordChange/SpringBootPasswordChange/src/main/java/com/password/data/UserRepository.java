package com.password.data;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.password.model.User;

public interface UserRepository extends MongoRepository<User, Long>{

}
