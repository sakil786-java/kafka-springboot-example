package com.javatechie.service;

import com.javatechie.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher  {

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Value("${app.kafka.topic-name}")
    private String topic;
    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send(topic, message);
        future.whenComplete((result,ex)->{
            if(ex==null)
            {

                System.out.println("Sent Message=[" +message+
                         "] with offset=[" +result.getRecordMetadata().offset()+"]");
            }
            else {
                System.out.println("Unable to send message=["+ message+"] due to : "+ex.getMessage());
            }
        });





    }
    public void sendEventsToTopic(Customer customer) {
        try {


            CompletableFuture<SendResult<String, Object>> future = template.send(topic, customer);
            future.whenComplete((result, ex) -> {
                if (ex == null) {

                    System.out.println("Sent Message=[" + customer +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" + customer + "] due to : " + ex.getMessage());
                }
            });
        }catch (Exception ex)
        {
            System.out.println("ERROR : "+ex.getMessage());
        }
    }


}
