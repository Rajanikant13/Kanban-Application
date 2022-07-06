package com.niit.authentication.service;

import com.niit.authentication.model.User;

import java.util.Map;

public interface TokenGenerator {
    public  Map<String,String>generate(User credential);
}
