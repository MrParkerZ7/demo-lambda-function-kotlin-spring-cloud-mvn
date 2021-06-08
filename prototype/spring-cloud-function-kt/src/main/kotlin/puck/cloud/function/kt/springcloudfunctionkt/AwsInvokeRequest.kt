package puck.cloud.function.kt.springcloudfunctionkt

import com.amazonaws.services.lambda.AWSLambda
import com.amazonaws.services.lambda.model.InvokeRequest
import com.amazonaws.services.lambda.model.ServiceException
import com.beust.klaxon.Klaxon
import java.nio.charset.StandardCharsets

class LambdaConfig {
    companion object {
        var env = Env.LAMBDA
    }

    enum class Env { LOCAL, LAMBDA }
}

fun invokeRequestLambda(body: String, lambdaClient: AWSLambda, functionName: String): String {
    val invokeRequest = InvokeRequest().withFunctionName(functionName)
    val jsonBody = Klaxon().toJsonString(body)

    if (LambdaConfig.env == LambdaConfig.Env.LOCAL)
        invokeRequest.withPayload("""{ "value": $jsonBody }""") // For locally payload
    else
        invokeRequest.withPayload(jsonBody) // For lambda payload

    try {
        val invokeResult = lambdaClient.invoke(invokeRequest)
        return String(invokeResult.payload.array(), StandardCharsets.UTF_8)
    } catch (e: ServiceException) {
        throw e
    }
}
