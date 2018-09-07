package br.edu.ifpb.eurecaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurecaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurecaServerApplication.class, args);
    }
}
