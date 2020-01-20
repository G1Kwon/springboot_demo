package com.acompany.restapp.controller;

import com.acompany.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/") // Controller 역할은 URL 매핑
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public Map<String, String> home() {

        Map<String, String> res = this.userService.getMassage();

//       비스니스 로직은 Controller 에서 처리하지 않는다.
//       Map <String, String> res = new HashMap<>();
//       res.put("great", "Hello world..");
        return res;
    }
}
