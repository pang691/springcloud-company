package com.taikang.cloud.controller;

import com.taikang.cloud.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/find/{id}")
    public User add(@PathVariable Long id) {
        ResponseEntity<User> forEntity = restTemplate.getForEntity("http://springcloud-user//user/"+id, User.class);
        return forEntity.getBody();
    }
}
