package br.edu.ifpb.tccacompanhamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class TCCAcompanhamentoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TCCAcompanhamentoApplication.class, args);
    }
}
