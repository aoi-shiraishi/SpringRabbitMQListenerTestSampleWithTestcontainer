package com.rabbitmqlistenertestsample

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<RabbitMqListenerTestSampleApplication>().with(TestcontainersConfiguration::class).run(*args)
}
