package br.unipar.trabalhopdvspring.ConfigSwagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI().info(new Info().title("PDV PROGRAMAÇÃO WEB E DESKTOP").version("1.0.0")
                .license(new License().name("ALUNO: RENATO DA CRUZ XAVIER  RA:238660-1 \n" +
                                            "ALUNO: ELIAS ANTONIO LOPATINI GASPERIN RA:236544-1")));
    }
    }
