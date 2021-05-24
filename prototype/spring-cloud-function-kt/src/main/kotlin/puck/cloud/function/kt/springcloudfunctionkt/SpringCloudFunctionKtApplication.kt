package puck.cloud.function.kt.springcloudfunctionkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.function.context.FunctionalSpringApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux
import java.util.function.Function

@SpringBootApplication
class SpringCloudFunctionKtApplication {
//    @Bean
//    fun normal(): Function<Flux<String>, Flux<Boolean>> = Function { it.map { it.contains("cloud") } }

    @Bean
    fun normal(): Function<String, Boolean> = Function { it.contains("cloud") }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringCloudFunctionKtApplication>(*args)
        }
    }
}

//fun main(args: Array<String>) {
//    runApplication<SpringCloudFunctionKtApplication>(*args)
//}