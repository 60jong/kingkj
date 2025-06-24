package dev.kingkj.caas.relay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RelayApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(RelayApplication.class);

        // TCP 소켓 서버 사용으로 Web은 사용하지 않는다.
        springApp.setWebApplicationType(WebApplicationType.NONE);
        springApp.run(args);
    }

}
