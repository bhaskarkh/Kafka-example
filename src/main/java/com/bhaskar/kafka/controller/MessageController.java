package com.bhaskar.kafka.controller;

import com.bhaskar.kafka.model.MessageRequest;
import com.bhaskar.kafka.model.Response;
import com.bhaskar.kafka.service.MessageResponseService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class MessageController {
    @Autowired
    MessageResponseService messageResponseService;
    @PostMapping("message")
    public Response publish(@RequestBody MessageRequest messageRequest)  {
        return messageResponseService.sendMessageToKafka(messageRequest);
    }
}
