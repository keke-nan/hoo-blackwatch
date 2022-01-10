//package com.holmes.hoo.blackwatch.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//
//
//@Configuration
//public class RabbitConfig {
//
//    @Bean
//    public DirectExchange errorAsyncExchange() {
//        return new DirectExchange(ProtocolConstant.RETRY_EXCHANGE);
//    }
//
//    @Bean
//    public Queue errorAsyncQueue() {
//        return new Queue(ProtocolConstant.RETRY_QUEUE, true);
//    }
//
//    @Bean
//    public Binding errorBinding(Queue errorAsyncQueue, DirectExchange errorAsyncExchange) {
//        return BindingBuilder.bind(errorAsyncQueue)
//                .to(errorAsyncExchange)
//                .with(ProtocolConstant.RETRY_ROUTE_KEY);
//    }
//
//
//    @Bean
//    public CustomExchange errorDelayExchange() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("x-delayed-type", "direct");
//        return new CustomExchange(ProtocolConstant.ERROR_RETRY_EXCHANGE, "x-delayed-message", true, false, map);
//    }
//
//    @Bean
//    public Queue errorDelayQueue() {
//        return new Queue(ProtocolConstant.ERROR_RETRY_QUEUE, true);
//    }
//
//    @Bean
//    public Binding errorDelayBinding(Queue errorDelayQueue, CustomExchange errorDelayExchange) {
//        return BindingBuilder.bind(errorDelayQueue)
//                .to(errorDelayExchange)
//                .with(ProtocolConstant.ERROR_RETRY_ROUTE_KEY).noargs();
//    }
//}
