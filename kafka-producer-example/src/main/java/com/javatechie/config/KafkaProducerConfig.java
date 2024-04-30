package com.javatechie.config;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.protocol.types.Field;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${app.kafka.topic-name}")
    private String topic;
    @Value("${app.kafka.partitions}")
    private int partitions;
    @Value("${app.kafka.replicationFactor}")
    private int replicationFactor;

    @Bean
    public NewTopic createTopic(){

        return new NewTopic(topic,partitions, (short) replicationFactor);
    }





    @Bean
    public Map<String,Object>producerConfig()
    {
        Map<String,Object>props=new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }


    @Bean
    public ProducerFactory<String,Object>producerFactory()
    {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    @Bean
    public KafkaTemplate<String,Object>kafkaTemplate()
    {
        return new KafkaTemplate<>(producerFactory());
    }

}
