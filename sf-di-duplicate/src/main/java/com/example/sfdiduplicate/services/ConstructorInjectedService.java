package com.example.sfdiduplicate.services;

import org.springframework.stereotype.Service;

@Service
public class ConstructorInjectedService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World!";
    }
}
