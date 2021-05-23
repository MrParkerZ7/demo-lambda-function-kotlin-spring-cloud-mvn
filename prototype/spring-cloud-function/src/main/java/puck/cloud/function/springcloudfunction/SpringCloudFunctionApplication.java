package puck.cloud.function.springcloudfunction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionApplication.class, args);
    }

    @Bean
    public Function<String, Boolean> containsCloud() {
        return value -> value.contains("cloud");
    }
}
