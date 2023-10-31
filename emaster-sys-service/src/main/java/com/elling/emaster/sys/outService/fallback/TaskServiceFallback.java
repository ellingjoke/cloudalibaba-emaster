package com.elling.emaster.sys.outService.fallback;

import com.elling.emaster.sys.outService.TaskServiceInterface;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceFallback implements TaskServiceInterface {
    @Override
    public String sayHello() {
        return "invoke remote sayHello interface,but something accure,now fallback";
    }

    @Override
    public String getFlowableTaskMessage() {
        return "invoke remote getFlowableTaskMessage interface,but something accure,now fallback";
    }
}
