package com.bhaskar.kafka.exception;

public class BhaskarErrorHandler extends RuntimeException {
    public BhaskarErrorHandler(String errorMessage) {super(errorMessage);}
}
