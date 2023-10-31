package com.elling.emaster.sys.outService;

import com.elling.emaster.sys.outService.fallback.TaskServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "emaster-flowable-service",fallback = TaskServiceFallback.class)
public interface TaskServiceInterface {
    @RequestMapping("/task/sayHello")
    public String sayHello();

    @RequestMapping("/task/getFlowableTaskMessage")
    public String getFlowableTaskMessage();
}
