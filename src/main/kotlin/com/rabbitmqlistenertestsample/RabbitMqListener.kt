package com.rabbitmqlistenertestsample

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Controller

@Controller
class RabbitMqListener(private val sampleService: SampleService) {
    @RabbitListener(queues = ["test-queue"])
    fun listen(message: String) {
        sampleService.sampleFunction()
    }
}