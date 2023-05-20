package com.bhaskar.kafka.model;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
public class Response {
    private String message;
    private String statusCode;
    private LocalDateTime time;
}
