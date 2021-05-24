package puck.cloud.function.springcloudfunction;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionApplication {

    public static void main(String[] args) {
        FunctionalSpringApplication.run(SpringCloudFunctionApplication.class, args);
    }

    @Bean
    public Function<String, Boolean> flux() {
        return str ->str.contains("cloud");
    }
}