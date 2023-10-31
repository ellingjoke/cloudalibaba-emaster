package com.elling.emaster.sys.controller;

import com.elling.emaster.sys.mq.MyProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/msgqueue/")
public class MsgProductorController {

    @Autowired
    private MyProducer myProducer;

    @RequestMapping("send/{str}")
    public void send(@PathVariable("str")String str){
        System.out.println("调用了。。1234");
        myProducer.sendMessage("TestTopic", str);
    }

    @RequestMapping("sendAddTask")
    public void sendAddTaskTag1(){
        System.out.println("调用了。。TASK_TOPIC");
        myProducer.sendMessage("TASK_TOPIC:tag1","abcTag1111");
    }

    @RequestMapping("sendAddTaskTag2")
    public void sendAddTaskTag2(){
        System.out.println("调用了。。TASK_TOPIC");
        myProducer.sendMessage("TASK_TOPIC:tag2","abcTag22222");
    }
}
