package com.example.demo;

import org.springframework.stereotype.Component;

//inversão de dependencia 
@Component
public class HelloGenerator {
    public String generateHello(){
        return "Hello, World!!! from generator";
    }
}
