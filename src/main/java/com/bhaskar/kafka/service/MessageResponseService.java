package com.bhaskar.kafka.service;

import com.bhaskar.kafka.exception.BhaskarErrorHandler;
import com.bhaskar.kafka.model.MessageRequest;
import com.bhaskar.kafka.model.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class MessageResponseService {
    private static final Logger logger = LoggerFactory.getLogger(MessageResponseService.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

  public Response sendMessageToKafka(MessageRequest messageRequest) {
    Response response = Response.builder().build();
    try {
      CompletableFuture<SendResult<String, String>> sendResult =
          kafkaTemplate.send("bhaskar", messageRequest.message());
      SendResult<String, String> result = sendResult.get(65000, TimeUnit.MILLISECONDS);
      logger.info("Successful delivery of {}", result.getProducerRecord());
      // response.
    } catch (Exception ex) {
      throw new BhaskarErrorHandler(ex.getMessage());
    }
    return response;
  }
}
