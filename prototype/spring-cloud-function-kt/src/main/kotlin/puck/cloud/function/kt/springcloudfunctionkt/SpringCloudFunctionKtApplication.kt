package puck.cloud.function.kt.springcloudfunctionkt

import com.amazonaws.regions.Regions
import com.amazonaws.services.lambda.AWSLambdaClientBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.function.Function


@SpringBootApplication
class SpringCloudFunctionKtApplication {

    @Bean
    fun handler(): Function<String, String> = Function {
        println("Begin")
        val lambdaClient = AWSLambdaClientBuilder.standard()
            .withRegion(Regions.AP_SOUTHEAST_1)
            .build()
        val functionName = "arn:aws:lambda:ap-southeast-1:598137816602:function:spring-cloud-function"

        invokeRequestLambda(
            body = it,
            lambdaClient = lambdaClient,
            functionName = functionName
        )
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<SpringCloudFunctionKtApplication>(*args)
        }
    }
}