package com.nashtech.service.impl;

import com.nashtech.model.Car;
import com.nashtech.service.CloudDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class KafkaService implements CloudDataService {

    /**
     * The KafkaTemplate for sending vehicle data to Kafka topics.
     */
    @Autowired
    private  KafkaTemplate<String, Car> kafkaTemplate;

    /**
     * Event hub topic name.
     */
    @Value("${eventhub.name}")
    private String eventHubName;


    /**
     * Sends the given {@link Car} object to the Kafka topic
     * The method constructs a Kafka message
     * from the provided {@link Car} payload
     * and sends it using the configured {@link KafkaTemplate}.
     *
     * @param reactiveDataCar The {@link Car} object to be sent to Kafka.
     * @throws KafkaException
     * If an error occurs while sending the message to Kafka.
     */
    @Override
    public Mono<Void> pushData(final Car reactiveDataCar)  {
        try {
            Message<Car> message = MessageBuilder
                    .withPayload(reactiveDataCar)
                    .setHeader(KafkaHeaders.TOPIC, eventHubName)
                    .build();
            kafkaTemplate.send(message);
        } catch (KafkaException kafkaException) {
            throw kafkaException;
        }
        return Mono.empty();
    }
}
