package com.taikang.cloud.controller;

import com.taikang.cloud.service.FeignService;
import com.taikang.cloud.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/feign/{id}")
    public User getById(@PathVariable("id") Long id){
        User user = feignService.getUserById(id);
        return user;
    }
    @GetMapping("/movie/{id}")
    public User getUserById(@PathVariable Long id){
        Map<Long,User> usermap = new HashMap<>();
        User user01 = new User(1l,"zhangdan001");
        User user02 = new User(2l,"lisi001");
        usermap.put(1l,user01);
        usermap.put(2l,user02);
        User user = usermap.get(id);
        System.out.println("movie1");
        return user;
    }
}
