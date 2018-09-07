package br.edu.ifpb.gateway;

import br.edu.ifpb.gateway.filters.pre.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableCircuitBreaker
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    @Bean
    public SimpleFilter simpleFilter() {
        return new SimpleFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}