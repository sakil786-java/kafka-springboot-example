# Kafka Spring Boot Example

This repository contains examples and instructions for using Apache Kafka with Spring Boot applications.

## Setting up Kafka

### Starting Zookeeper


C:\kafka_2.13-3.6.0>bin\windows\zookeeper-server-start.bat config\zookeeper.properties

###  Starting Kafka

C:\kafka_2.13-3.6.0>bin\windows\kafka-server-start.bat config\server.properties
###  Working with Kafka Topics
#####  Creating a New Topic

C:\kafka_2.13-3.6.0>bin\windows\kafka-topics.bat --create --topic javatechie_spring-topic1 --partitions 3 --replication-factor 1 --bootstrap-server localhost:9092

#####  Listing Topics


C:\kafka_2.13-3.6.0>bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

#####  Describing a Topic
C:\kafka_2.13-3.6.0>bin\windows\kafka-topics.bat --describe --topic javatechie_spring-topic --bootstrap-server localhost:9092
###  Producing and Consuming Messages
#####  Producing Messages
C:\kafka_2.13-3.6.0>bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic javatechie_spring-topic
#####  Consuming Messages
C:\kafka_2.13-3.6.0>bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic javatechie_spring-topic --from-beginning
###  Docker Setup
Starting Kafka with Docker
docker-compose -f docker-compose.yml up -d
#####  Notes
Replace C:\kafka_2.13-3.6.0 with the path to your Kafka installation directory.
Make sure to replace topic names and other parameters with your specific configurations.



This single README file provides all the instructions for setting up Kafka, working with topics, producing and consuming messages, using Docker with Kafka, and includes important notes for customization, all in Markdown format.





