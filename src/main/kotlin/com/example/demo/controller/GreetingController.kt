package com.example.demo.controller

import com.example.demo.service.GreetingService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(
    private val greetingService: GreetingService
) {
    @RequestMapping("/test/greet.json")
    fun greeting(): String = greetingService.greet()
}
