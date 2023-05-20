package com.bhaskar.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

  @KafkaListener(topics = "bhaskar", groupId = "groupId")
  void listener(String data) {
    System.out.println("Listener Received : " + data);
  }
}
