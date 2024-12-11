package com.rabbitmqlistenertestsample

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito.verify
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.RabbitMQContainer

@Import(TestcontainersConfiguration::class)
@SpringBootTest
class RabbitMqListenerTest {

    @Autowired
    private lateinit var rabbitTemplate: RabbitTemplate

    @Autowired
    private lateinit var rabbitMqContainer: RabbitMQContainer

    @MockitoBean
    private lateinit var sampleService: SampleService

    @BeforeEach
    fun setUp() {
        rabbitMqContainer.start()
    }

    @AfterEach
    fun tearDown() {
        rabbitMqContainer.stop()
    }

    @Test
    fun listen() {

        rabbitTemplate.convertAndSend("test-queue", "Hello, World!")

        verify(sampleService).sampleFunction()
    }
}