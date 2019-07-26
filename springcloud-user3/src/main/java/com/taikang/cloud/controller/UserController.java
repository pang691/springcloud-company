package com.taikang.cloud.controller;

import com.taikang.cloud.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        Map<Long,User> usermap = new HashMap<>();
        User user01 = new User(1l,"zhangdan");
        User user02 = new User(2l,"lisi");
        usermap.put(1l,user01);
        usermap.put(2l,user02);
        User user = usermap.get(id);
        System.out.println("user2");
        return user;
    }
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/findMovie/{id}")
    public User add(@PathVariable Long id) {
        ResponseEntity<User> forEntity = restTemplate.getForEntity("http://springcloud-movie/movie/"+id, User.class);
        return forEntity.getBody();
    }
}
