package com.example.demo

import com.example.demo.service.GreetingService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@AutoConfigureMockMvc
class WebMockTest(
    val greetingService: GreetingService,
    val mockMvc: MockMvc
) {
    @Test
    @Throws(Exception::class)
    internal fun `greetingShouldReturnMessageFromService`() {
//        Mockito.`when`(greetingService.greet()).thenReturn("Hello, Greeting")
        var result = greetingService.greet()

        assertThat(result).isNotNull()
        assertThat(result).isEqualTo("Hello, Greeting")
    }

    @Test
    @Throws(Exception::class)
    internal fun `greetingShouldReturnMessageFromController`() {
        val actions = mockMvc.perform(get("/test/greet.json"))

        actions
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string("Hello, Greeting"))
    }
}
