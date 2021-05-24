package puck.cloud.function.kt.springcloudfunctionkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Function

@SpringBootApplication
class SpringCloudFunctionKtApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudFunctionKtApplication>(*args)
}

@Bean
fun flux(): Function<String, Boolean> = Function { str -> str.contains("cloud") }