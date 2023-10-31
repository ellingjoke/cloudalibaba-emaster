package com.elling.emaster.flowable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/task/")
public class TaskController {
    @Value("${server.port}")
    private String port;

    //注入配置上下文
    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @RequestMapping(value = "/sayHello")
    public String sayHello(){
        String userNameInConfig = applicationContext.getEnvironment().getProperty("user.newname");
        String nameserver = applicationContext.getEnvironment().getProperty("rocketmq.name-server");
        Long timer = new Date().getTime();
        return "Hello who are you:"+ timer + ",from config's user.name333:  " + userNameInConfig+",nameserver:"+nameserver;
    }

    @RequestMapping(value = "/getFlowableTaskMessage")
    public String getFlowableTaskMessage(){
        return "当前接收到的消息为该服务由端口：" + port + "提供";
    }

    @RequestMapping(value = "/getFlowableTaskMessage2/{message}")
        public String getFlowableTaskMessage2(@PathVariable String message){
            return "当前接收到的消息为：" + message  + "，该服务由端口：" + port + "提供";
    }



}
