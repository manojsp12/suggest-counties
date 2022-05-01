package com.example.counties.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Suggest Counties")
                        .description(
                                "Get suggested counties based on provided query string. Responds with an array, limited to 5 results, of counties where the county name or state matches the provided query string.")
                        .version("1.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Suggest Counties README")
                        .url("https://github.com/manojsp12/suggest-counties/blob/main/README.md")
                        .description("Java docs")
                        .url("url"));
    }
}
