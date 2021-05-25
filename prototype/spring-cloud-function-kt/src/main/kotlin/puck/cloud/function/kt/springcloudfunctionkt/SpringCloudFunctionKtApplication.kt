package puck.cloud.function.kt.springcloudfunctionkt

import org.reactivestreams.Publisher
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.function.Function

@SpringBootApplication
class SpringCloudFunctionKtApplication {
    @Bean
    fun normal(): Function<String, Boolean> = Function { it.contains("cloud") }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringCloudFunctionKtApplication>(*args)
        }
    }
}