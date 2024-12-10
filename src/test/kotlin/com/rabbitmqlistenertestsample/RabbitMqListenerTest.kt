package com.rabbitmqlistenertestsample

import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class RabbitMqListenerTest {

    @Autowired
    private lateinit var rabbitTemplate: RabbitTemplate

    @MockitoBean
    private lateinit var sampleService: SampleService

    @Test
    fun listen() {

        rabbitTemplate.convertAndSend("test-queue", "Hello, World!")

        verify(sampleService).sampleFunction()
    }
}