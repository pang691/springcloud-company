package com.taikang.cloud.service;

import com.taikang.cloud.vo.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("springcloud-movie")
public interface FeignService {
    @RequestMapping(value = "/movie/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id);
}
