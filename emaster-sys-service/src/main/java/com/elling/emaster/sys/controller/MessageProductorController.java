//package com.elling.emaster.sys.controller;
//
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.apache.rocketmq.spring.support.RocketMQHeaders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MessageProductorController {
//
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//
//    public SendResult sentTaskMessage(@RequestParam(defaultValue = "all") String tag,@RequestParam(required = false) Long delayTime,@RequestParam(required = false) Long delayLevel){
//        String destination = RocketMQConstant.TOPIC + ":" + tag;
//
//        UserChange change = UserChange.builder().userName("张三").remark("密码变更").build();
//        Message<UserChange> message = MessageBuilder.withPayload(change).setHeader(RocketMQHeaders.KEYS, "key").build();
//        log.info("准备发送消息");
//        if (delayTime != null) { // 按时间延迟消息
//            // RocketMQ_4.9.x版本不支持延迟时间，指定时间无效
//            return rocketMQTemplate.syncSendDelayTimeMills(destination, message, 5000L);
//        } else if (delayLevel != null) { // 按级别延迟消息
//            return rocketMQTemplate.syncSend(destination, message, 5000L, delayLevel);
//        } else {
//            return rocketMQTemplate.syncSend(destination, message);
//        }
//
//    }
//
//
//}
