package com.javaprogramto.activemq.activemqstandalonedemo.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {


    Logger logger = LoggerFactory.getLogger(getClass());


    @JmsListener(destination = "standalone-activemq-queue")
    public void consume(String message){

        logger.info("Message received : "+message);
    }
}
