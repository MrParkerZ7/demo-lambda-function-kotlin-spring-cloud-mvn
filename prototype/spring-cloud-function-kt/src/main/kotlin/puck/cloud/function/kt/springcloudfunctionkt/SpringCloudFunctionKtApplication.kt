package puck.cloud.function.kt.springcloudfunctionkt

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Function

@SpringBootApplication
class SpringCloudFunctionKtApplication {

    @Bean
    fun handler(): Function<String, Boolean> = Function { it.contains("cloud") }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringCloudFunctionKtApplication>(*args)
        }
    }
}