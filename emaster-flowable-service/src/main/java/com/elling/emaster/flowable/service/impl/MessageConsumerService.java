//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.stereotype.Component;
//
//@Component
//@Slf4j
//public class MessageConsumerService {
//
//    @Component
//    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC, consumerGroup = "consumer-group1", selectorExpression = "all||tag1")
//    public class Consumer1 implements RocketMQListener<MessageExt> {
//        @Override
//        public void onMessage(MessageExt message) {
//            log.info("收到信息：{}，Keys={}，Topic={}", new String(message.getBody()), message.getKeys(), message.getTopic());
//        }
//    }
//
//    @Component
//    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC, consumerGroup = "consumer-group2", selectorExpression = "all||tag2")
//    public class Consumer2 implements RocketMQListener<String> {
//        @Override
//        public void onMessage(String message) {
//            log.info("收到信息：{}", message);
//        }
//    }
//
//    @Component
//    @RocketMQMessageListener(topic = RocketMQConstant.TOPIC, consumerGroup = "consumer-group3", selectorExpression = "all||tag3")
//    public class Consumer3 implements RocketMQListener<UserChange> {
//        @Override
//        public void onMessage(UserChange message) {
//            log.info("收到信息：{}", JSON.toJSONString(message));
//        }
//    }
//}