package com.rabbitmqlistenertestsample

import org.springframework.amqp.core.Queue
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.RabbitMQContainer

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

//    @Bean
//    @ServiceConnection
//    fun rabbitContainer(): RabbitMQContainer {
//        return RabbitMQContainer(DockerImageName.parse("rabbitmq:latest"))
//    }

    // TODO: 上のコメントアウトだと動かない現象の解決方法を調査する
    @Bean
    fun rabbitMQContainer(): RabbitMQContainer {
        val container = RabbitMQContainer("rabbitmq:3.8-management-alpine")
        container.start()
        System.setProperty("spring.rabbitmq.host", container.host)
        System.setProperty("spring.rabbitmq.port", container.getMappedPort(5672).toString())
        return container
    }

    @Bean
    fun queue(): Queue {
        return Queue("test-queue")
    }

}
