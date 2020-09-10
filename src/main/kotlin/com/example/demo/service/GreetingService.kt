package com.example.demo.service

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun greet(): String {
        return "Hello, Greeting"
    }
}
