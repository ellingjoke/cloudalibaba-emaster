package com.elling.emaster.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
@RequestMapping("/user/")
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${spring.application.name}")
    private String appName;

    @RequestMapping("sayHello")
    public String sayHello(){
        return new Date().getTime() +"hello cyy";
    }

    /**
     * 使用loadBalancerClient 和 restTemplate相结合的方式来访问
     * @return
     */
    @RequestMapping("/getTaskFromFlowableService")
    public String getTaskFromFlowableService(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("emaster-flowable-service");
        String url = String.format("http://%s:%s/task/getFlowableTaskMessage",serviceInstance.getHost(),serviceInstance.getPort());
        return restTemplate.getForObject(url,String.class);
    }







}
