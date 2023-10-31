package com.elling.emaster.sys.controller;

import com.elling.emaster.sys.outService.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userTask/")
public class UserTaskController {
    @Autowired
    private TaskServiceInterface taskServiceInterface;


    @RequestMapping("sayHello")
    public String sayHello(){
        return taskServiceInterface.sayHello();
    }
    @RequestMapping("getTaskFromRemote")
    public String getTaskFromRemote(){
        return taskServiceInterface.getFlowableTaskMessage();
    }
}
