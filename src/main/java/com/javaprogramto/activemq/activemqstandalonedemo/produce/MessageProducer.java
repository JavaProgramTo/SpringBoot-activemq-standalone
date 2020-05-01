package com.javaprogramto.activemq.activemqstandalonedemo.produce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/standalone/publish")
public class MessageProducer {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/{message}")
    public String publish(@PathVariable("message") String message ){

        jmsTemplate.convertAndSend(queue, message);

        logger.info("Message Published : "+message);
        return "Message Published";
    }
}
