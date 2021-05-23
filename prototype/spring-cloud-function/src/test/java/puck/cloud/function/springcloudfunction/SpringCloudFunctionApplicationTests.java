package puck.cloud.function.springcloudfunction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@FunctionalSpringBootTest
@AutoConfigureWebTestClient
class SpringCloudFunctionApplicationTests {

    @Autowired
    private WebTestClient client;

    @Test
    void doesContainsCloud() {
        client.post().uri("/containsCloud").body(Mono.just("this is a cloud"), String.class).exchange()
                .expectStatus().isOk().expectBody(String.class).isEqualTo("true");
    }

    @Test
    void doesNotContainsCloud() {
        client.post().uri("/containsCloud").body(Mono.just("this is a function"), String.class).exchange()
                .expectStatus().isOk().expectBody(String.class).isEqualTo("false");
    }
}
