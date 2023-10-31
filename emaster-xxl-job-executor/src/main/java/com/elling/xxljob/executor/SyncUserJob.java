package com.elling.xxljob.executor;

import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class SyncUserJob {

    @XxlJob("userJobHandler")
    public void userJobHandler(){
        System.out.println("定时处理器处理用户数据");
    }

}
