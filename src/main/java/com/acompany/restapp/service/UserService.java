package com.acompany.restapp.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    public Map<String, String> getMassage() {

         Map <String, String> res = new HashMap<>();
         res.put("great", "Hello world..");

         return res;
    }
}
