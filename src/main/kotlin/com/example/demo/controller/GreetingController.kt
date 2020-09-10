package com.example.demo.controller

import com.example.demo.service.GreetingService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController(
    private val greetingService: GreetingService
) {
    @RequestMapping("/test/greet.json")
    @ResponseBody
    fun greeting(): String = greetingService.greet()
}
