//package com.holmes.hoo.blackwatch.listener;
//
//import com.holmes.hoo.blackwatch.utils.MqProductUtil;
//import com.rabbitmq.client.Channel;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.io.IOException;
//
///**
// * @author A20019
// * @since 2022/1/10 15:07
// */
//@Slf4j
//@Component
//public class RetryEventListener {
//
//    @Resource
//    private MqProductUtil mqProductUtil;
//    @Value("${service.delay-time:10000}")
//    private int delayTime;
//
//
//    @RabbitHandler
//    @RabbitListener(queues = ProtocolConstant.RETRY_QUEUE)
//    public void consumerErrorMsg(Message message, Channel channel) throws IOException {
//        log.info("消息监听: {}", new String(message.getBody()));
//        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        channel.basicAck(deliveryTag, Boolean.FALSE);
//        ////            channel.basicNack(deliveryTag, Boolean.FALSE, Boolean.TRUE);
//        //消息处理，延迟10秒消费
//    }
//}
