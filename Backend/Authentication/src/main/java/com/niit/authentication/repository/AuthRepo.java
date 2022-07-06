package com.niit.authentication.repository;

import  com.niit.authentication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepo extends JpaRepository<User,Integer> {

    public abstract User findByidAndPassword(String name,String password);
    public abstract User findByEmailAndPassword(String name,String password);
    public abstract User findByEmail(String email);


}
