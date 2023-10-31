package com.elling.emaster.flowable.cmconsumer;

import com.alibaba.fastjson.JSON;
import com.elling.emaster.flowable.constant.RocketMQConstant;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TaskMqConsumer {
    private Logger log = LoggerFactory.getLogger(TaskMqConsumer.class);

    @Component
    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC_TASK, consumerGroup = "consumer-group1", selectorExpression = "all||tag1" ,selectorType = SelectorType.TAG)
    public class Consumer1 implements RocketMQListener<MessageExt> {
        @Override
        public void onMessage(MessageExt message) {
            System.out.println("tags是：：："+message.getTags());
            System.out.println("收到信息11：{}，Keys={}，Topic={}"+new String(message.getBody())+message.getKeys()+message.getTopic());
            log.info("收到信息：{}，Keys={}，Topic={}", new String(message.getBody()), message.getKeys(), message.getTopic());
        }
    }

    @Component
    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC_TASK, consumerGroup = "consumer-group2", selectorExpression = "tag2")
    public class Consumer2 implements RocketMQListener<String> {
        @Override
        public void onMessage(String message) {
            System.out.println("收到信息：{}"+ message);
            log.info("收到信息：{}", message);
        }
    }

    @Component
    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC_TASK, consumerGroup = "consumer-group3")
    public class Consumer3 implements RocketMQListener<MessageExt> {
        @Override
        public void onMessage(MessageExt message) {
            System.out.println("tags是：：："+message.getTags());
            System.out.println("收到信息：{}，Keys={}，Topic={}"+new String(message.getBody())+message.getKeys()+message.getTopic());
            log.info("收到信息：{}，Keys={}，Topic={}", new String(message.getBody()), message.getKeys(), message.getTopic());
        }
    }

//    @Component
//    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC_TASK, consumerGroup = "consumer-group3", selectorExpression = "all||tag3")
//    public class Consumer3 implements RocketMQListener<UserChange> {
////        @Override
////        public void onMessage(UserChange message) {
////            log.info("收到信息：{}", JSON.toJSONString(message));
////        }
//        @Override
//        public void onMessage(String message) {
//            log.info("收到信息：{}", JSON.toJSONString(message));
//        }
//    }
}
