package com.niit.authentication.service;



import com.niit.authentication.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class TokenGeneratorImpl implements TokenGenerator{


    @Override
    public Map<String, String> generate(User user) {

        Date cd = new Date();
        cd.setMinutes(cd.getMinutes()+15);

        System.out.println("\n\nExisting claims : " + Jwts.claims().values());
        String jwttoken=Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(cd) // current datetime + 5 minutes
                .signWith(SignatureAlgorithm.HS512,"mykey").compact();
        Map<String, String> map = new HashMap();
        map.put("token",jwttoken);
        map.put("message","User successfully logged in");
        return map;



    }
}
