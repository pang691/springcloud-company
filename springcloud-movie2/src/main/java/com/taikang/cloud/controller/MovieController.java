package com.taikang.cloud.controller;

import com.taikang.cloud.vo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MovieController {

    @GetMapping("/movie/{id}")
    public User getUserById(@PathVariable Long id){
        Map<Long,User> usermap = new HashMap<>();
        User user01 = new User(1l,"zhangdan001");
        User user02 = new User(2l,"lisi001");
        usermap.put(1l,user01);
        usermap.put(2l,user02);
        User user = usermap.get(id);
        System.out.println("movie2");
        return user;
    }
}
