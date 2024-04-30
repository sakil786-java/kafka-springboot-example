package com.javatechie.consumer;


import com.javatechie.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



@Service
public class KafkaMessageListener {
    Logger logger= LoggerFactory.getLogger(KafkaMessageListener.class);


    @KafkaListener(topics = "${app.kafka.topic-name}",groupId = "${app.kafka.group-id}")
    public  void consume(Customer customer)
    {
        logger.info("Consumer1 consume the events {} ",customer.toString());
    }
/*
    @KafkaListener(topics = "spring-topic-new2",groupId = "java-group-new3")
    public  void consume2(String message)
    {
        logger.info("Consumer2 consume the message {} ",message);
    }
    @KafkaListener(topics = "spring-topic-new2",groupId = "java-group-new3")
    public  void consume3(String message)
    {
        logger.info("Consumer3 consume the message {} ",message);
    }
    @KafkaListener(topics = "spring-topic-new2",groupId = "java-group-new3")
    public  void consume4(String message)
    {
        logger.info("Consumer4 consume the message {} ",message);
    }

 */
}
