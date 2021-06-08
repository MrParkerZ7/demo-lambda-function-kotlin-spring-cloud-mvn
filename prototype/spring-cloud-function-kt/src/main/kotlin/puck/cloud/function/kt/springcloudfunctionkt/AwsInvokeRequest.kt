package puck.cloud.function.kt.springcloudfunctionkt

import com.amazonaws.services.lambda.AWSLambda
import com.amazonaws.services.lambda.model.InvokeRequest
import com.amazonaws.services.lambda.model.ServiceException
import com.fasterxml.jackson.databind.util.JSONPObject
import java.nio.charset.StandardCharsets

class LambdaConfig {
    companion object {
        var env = Env.LAMBDA
    }

    enum class Env { LOCAL, LAMBDA }
}

fun invokeRequestLambda(body: String, lambdaClient: AWSLambda, functionName: String): String {
    val invokeRequest = InvokeRequest().withFunctionName(functionName)

    if (LambdaConfig.env == LambdaConfig.Env.LOCAL)
        invokeRequest.withPayload("""{"value": "$body"}""") // For locally payload
    else
        invokeRequest.withPayload(body) // For lambda payload

    try {
        val invokeResult = lambdaClient.invoke(invokeRequest)
        println("Raw result: ${invokeResult.payload}")
        val ans = String(invokeResult.payload.array(), StandardCharsets.UTF_8)

        println("Result: $ans")
        return ans
    } catch (e: ServiceException) {
        println("Error: $e")
        throw e
    }
}
