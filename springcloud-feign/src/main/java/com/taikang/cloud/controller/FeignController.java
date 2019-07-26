package com.taikang.cloud.controller;

import com.netflix.discovery.EurekaClient;
import com.taikang.cloud.service.FeignService;
import com.taikang.cloud.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/feign/{id}")
    public User getById(@PathVariable("id") Long id){
        User user = feignService.getUserById(id);
        return user;
    }

    @GetMapping("/feign/in")
    public String getId(){
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-movie");
        instances.stream().forEach(serviceInstance -> {
            System.out.println(serviceInstance.getServiceId()+":"+serviceInstance.getPort());
        });
        List<String> services = discoveryClient.getServices();
        services.stream().forEach(service -> {
            System.out.println("服务为:"+service);
        });
        return "1";
    }

}
