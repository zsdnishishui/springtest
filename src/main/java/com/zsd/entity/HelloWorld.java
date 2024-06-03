package com.zsd.entity;

import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorld {

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println("message : " + message);
    }
}
