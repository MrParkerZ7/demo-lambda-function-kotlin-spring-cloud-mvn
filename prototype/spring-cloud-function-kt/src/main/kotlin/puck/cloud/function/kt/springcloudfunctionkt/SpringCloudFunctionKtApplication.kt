package puck.cloud.function.kt.springcloudfunctionkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Function

@SpringBootApplication
class SpringCloudFunctionKtApplication {
    @Bean
    fun normal(): Function<String, Boolean> {
        return Function { value: String -> value.contains("cloud") }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringCloudFunctionKtApplication>(*args)
}


