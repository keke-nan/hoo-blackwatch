package com.holmes.hoo.blackwatch.utils;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author A20019
 * @since 2021/12/17 17:45
 */
@Slf4j
@Component
public class MqProductUtil implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    @Resource
    RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     */
    //public void sendPushMessage(String exchange, String routingKey, String content) {
    //    //消息回调参数
    //    MessageCallBack callbackDto = new MessageCallBack();
    //    callbackDto.setMessageId(String.valueOf(IdWorker.getId()));
    //    callbackDto.setExchange(exchange);
    //    callbackDto.setRoutingKey(routingKey);
    //    callbackDto.setRetryCount(0);
    //    callbackDto.setContent(content);
    //    sendPushMessage(callbackDto);
    //}
    //
    //private void sendPushMessage(MessageCallBack callbackDto) {
    //    Message msg = MessageBuilder.withBody(callbackDto.getContent().getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON)
    //            .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
    //            .setContentEncoding("utf-8").setMessageId(callbackDto.getMessageId()).build();
    //    CorrelationData correlationData = new CorrelationData(callbackDto.toString());
    //
    //    rabbitTemplate.setMandatory(true);
    //    rabbitTemplate.setConfirmCallback(this);
    //    rabbitTemplate.setReturnCallback(this);
    //    rabbitTemplate.convertAndSend(callbackDto.getExchange(), callbackDto.getRoutingKey(), msg, correlationData);
    //}


    public void sendDelayMessage(String exchange, String routingKey, Integer delayTime, String content) {
        Message msg = MessageBuilder.withBody(content.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT)
                .setContentEncoding("utf-8").build();
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.convertAndSend(exchange, routingKey, msg, message -> {
            message.getMessageProperties().setDelay(delayTime);
            return message;
        });
    }


    /**
     * 发送消息确认机制
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("broker ack! mq send " + (ack ? "success" : "failed") + JSON.toJSONString(correlationData));
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.error("Queue fail: exchange: {}, route: {}, replyCode: {}, replyText: {}, message: {}", exchange, routingKey, replyCode, replyText, message);
    }
}
