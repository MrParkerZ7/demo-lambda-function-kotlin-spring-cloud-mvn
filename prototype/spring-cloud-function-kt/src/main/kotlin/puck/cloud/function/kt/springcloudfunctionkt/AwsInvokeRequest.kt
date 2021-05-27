package puck.cloud.function.kt.springcloudfunctionkt

import com.amazonaws.regions.Regions
import com.amazonaws.services.lambda.AWSLambdaClientBuilder
import com.amazonaws.services.lambda.model.InvokeRequest
import com.amazonaws.services.lambda.model.ServiceException
import java.nio.charset.StandardCharsets

class LambdaConfig {
    companion object {
        var env = Env.LAMBDA
    }

    enum class Env { LOCAL, LAMBDA }
}

fun invokeRequestLambda(str: String): String {
    val functionName = "arn:aws:lambda:ap-southeast-1:598137816602:function:spring-cloud-function"
    println("Request: $str")
    println("Function Name: $functionName")
    val invokeRequest = InvokeRequest().withFunctionName(functionName)

    if (LambdaConfig.env == LambdaConfig.Env.LOCAL)
        invokeRequest.withPayload("""{"value": "$str"}""") // For locally payload
    else
        invokeRequest.withPayload(str) // For lambda payload

    try {
        val awsLambda = AWSLambdaClientBuilder.standard()
            .withRegion(Regions.AP_SOUTHEAST_1)
            .build()
        val invokeResult = awsLambda.invoke(invokeRequest)
        println("Raw result: ${invokeResult.payload}")
        val ans = String(invokeResult.payload.array(), StandardCharsets.UTF_8)

        println("Result: $ans")
        return ans
    } catch (e: ServiceException) {
        println("Error: $e")
        throw e
    }
}
