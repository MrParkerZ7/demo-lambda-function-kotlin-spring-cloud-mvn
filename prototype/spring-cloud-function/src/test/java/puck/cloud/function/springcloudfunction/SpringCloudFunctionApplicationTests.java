package puck.cloud.function.springcloudfunction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import org.springframework.core.serializer.Serializer;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

@FunctionalSpringBootTest
@AutoConfigureWebTestClient
class SpringCloudFunctionApplicationTests {

    @Autowired
    private WebTestClient client;

    @Test
    void fluxTrue() {
        client.post().uri("/flux").body(Mono.just("this is a cloud"), String.class).exchange()
                .expectStatus().isOk().expectBody(String.class).isEqualTo("this is a cloud");
    }

    @Test
    void fluxFalse() {
        client.post().uri("/flux").body(Mono.just("this is a function"), String.class).exchange()
                .expectStatus().isOk().expectBody(String.class).isEqualTo("this is a function");
    }
}
