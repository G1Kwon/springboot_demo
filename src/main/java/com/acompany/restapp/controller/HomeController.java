package com.acompany.restapp.controller;

import com.acompany.restapp.service.SecurityServiceImpl;
import com.acompany.restapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/") // Controller 역할은 URL 매핑
public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private SecurityServiceImpl securityService;

    @GetMapping("")
    public Map<String, String> home() {

        Map<String, String> res = this.userService.getMassage();

//       비스니스 로직은 Controller 에서 처리하지 않는다.
//       Map <String, String> res = new HashMap<>();
//       res.put("great", "Hello world..");
        return res;
    }

    //토큰 발행
    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject) {
        String token = securityService.createToken(subject, 100*60*60*24L);
        Map<String, Object> map = new HashMap<>();
        map.put("userid", subject);
        map.put("token", token);
        return map;
    }

    //토큰 요청
    @GetMapping("security/get/subject")
    public String getSubject(@RequestParam String token) {
        String subject = securityService.getSubject(token);
        return subject;
    }
}
