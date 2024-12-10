package com.rabbitmqlistenertestsample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RabbitMqListenerTestSampleApplication

fun main(args: Array<String>) {
    runApplication<RabbitMqListenerTestSampleApplication>(*args)
}
