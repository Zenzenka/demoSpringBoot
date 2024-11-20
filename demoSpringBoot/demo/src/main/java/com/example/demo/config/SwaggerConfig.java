package com.example.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API RESTful - Sistema de Clientes, Produtos e Pedidos")
                        .description("Documentação da API para gerenciar clientes, produtos e pedidos.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Zenka Dev")
                                .email("zenka@example.com")
                                .url("https://github.com/zenka"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação Completa")
                        .url("https://swagger.io/"));
    }
}
