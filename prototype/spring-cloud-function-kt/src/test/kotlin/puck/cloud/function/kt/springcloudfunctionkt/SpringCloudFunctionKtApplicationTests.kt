package puck.cloud.function.kt.springcloudfunctionkt

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@FunctionalSpringBootTest
@AutoConfigureWebTestClient
internal class SpringCloudFunctionKtApplicationTests {
    @Autowired
    private val client: WebTestClient? = null

    @Test
    fun doesContainsCloud() {
        client!!.post().uri("/handler")
            .body(Mono.just("this is a cloud"), String::class.java)
            .exchange().expectStatus().isOk
            .expectBody(String::class.java)
    }

    @Test
    fun doesNotContainsCloud() {
        client!!.post().uri("/handler")
            .body(Mono.just("this is a function"), String::class.java)
            .exchange().expectStatus().isOk
            .expectBody(String::class.java)
    }
}
