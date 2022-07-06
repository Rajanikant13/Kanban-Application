package com.niit.notification.repository;

import com.niit.notification.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends MongoRepository<UserDetails,String> {

    public UserDetailsRepo findByName(String name);

}
