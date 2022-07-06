package com.niit.project.repository;

import com.niit.project.exception.NotFoundException;
import com.niit.project.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends MongoRepository<User,Integer> {
    public User findByName(String name)throws NotFoundException;
    public User findByEmail(String email);
}
