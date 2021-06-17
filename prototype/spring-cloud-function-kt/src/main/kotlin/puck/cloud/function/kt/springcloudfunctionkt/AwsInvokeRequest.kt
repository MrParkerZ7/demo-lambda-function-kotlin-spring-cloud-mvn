package puck.cloud.function.kt.springcloudfunctionkt

import com.amazonaws.services.lambda.AWSLambda
import com.amazonaws.services.lambda.model.InvokeRequest
import com.amazonaws.services.lambda.model.ServiceException
import com.beust.klaxon.Klaxon
import com.fasterxml.jackson.databind.ObjectMapper
import java.nio.charset.StandardCharsets

class LambdaConfig {
    companion object {
        var env = Env.LAMBDA
    }

    enum class Env { LOCAL, LAMBDA }
}

val klaxon = Klaxon()
inline fun <reified T> invokeRequestLambda(body: Any, lambdaClient: AWSLambda, functionName: String): T? {
    val invokeRequest = InvokeRequest().withFunctionName(functionName)
    val jsonBody = klaxon.toJsonString(body)

    if (LambdaConfig.env == LambdaConfig.Env.LOCAL)
        invokeRequest.withPayload("""{ "value": $jsonBody }""")
    else
        invokeRequest.withPayload(jsonBody)
    try {
        val invokeResult = lambdaClient.invoke(invokeRequest)
        println("XXX" + invokeResult.payload)
        invokeResult.payload.array().forEach {
            println("XXX :: $it")
        }
        val result = String(invokeResult.payload.array(), StandardCharsets.UTF_8)
        return klaxon.parse<T>(result)
    } catch (e: ServiceException) {
        throw e
    }
}
