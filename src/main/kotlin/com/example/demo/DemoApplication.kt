package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class DemoApplication

private var applicationContext: ApplicationContext? = null

fun main(args: Array<String>) {
    applicationContext = runApplication<DemoApplication>(*args)
}
