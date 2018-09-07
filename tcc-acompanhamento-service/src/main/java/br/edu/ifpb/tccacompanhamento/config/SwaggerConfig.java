package br.edu.ifpb.tccacompanhamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.edu.ifpb.tccacompanhamento.web"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "IFPB-Serviço |TCC-Acompanhamento",
                "API TCC-Acompanhamento",
                "",
                "",
                new Contact("IFPB-TCC-Acompanhamento", "https://github.com/ifpb/TCC-IFPB/tree/master/TCC-Acompanhamento",
                        "bromulosoares@gmail.com"),
                "Apache License Version 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0"
        );

        return apiInfo;
    }
}


