package com.example.wftraining.producers;

import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.example.wftraining.domains.CustomerEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomerEventsProducer {
	@Autowired
    KafkaTemplate<Integer,String> kafkaTemplate;
	
	String topic = "user-registrations";
    @Autowired
    ObjectMapper objectMapper;
    
    public void createUserEvent(CustomerEvent cust) throws JsonProcessingException {
    	cust.setCustomerEventType("post");
    	publishEvent(cust);
    }
    
    public void updateCustomerEvent(CustomerEvent cust) throws JsonProcessingException {
    	cust.setCustomerEventType("put");
        publishEvent(cust);
    }
    
    private void publishEvent(CustomerEvent cust) throws JsonProcessingException{
    	Integer key = cust.getCustomerEventID();
        String value = objectMapper.writeValueAsString(cust);
        ProducerRecord<Integer,String> producerRecord = buildProducerRecord(key, value, topic);

        //TODO: Why customer ID null
        ListenableFuture<SendResult<Integer,String>> listenableFuture =  kafkaTemplate.send(producerRecord);

        listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(key, value, ex);
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                handleSuccess(key, value, result);
            }
        });
    }
    
    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {


        List<Header> recordHeaders = List.of(new RecordHeader("event-source", "scanner".getBytes()));

        return new ProducerRecord<>(topic, null, key, value, recordHeaders);
    }
    
    private void handleFailure(Integer key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());
        try {
            throw ex;
        } catch (Throwable throwable) {
            log.error("Error in OnFailure: {}", throwable.getMessage());
        }


    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}", key, value, result.getRecordMetadata().partition());
    }
}
