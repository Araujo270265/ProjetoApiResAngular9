package br.com.marinha.apiativos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration  {
	
	@Bean
	public Docket Api() {
	    return new Docket(DocumentationType.SWAGGER_2)
      
	    .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.marinha.apiativos"))
        .paths(regex("/api.*"))
        .build()
        .useDefaultResponseMessages(false)
        .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Serviço Api Rest")
	            .description("Exemplo de consumação de Serviço Rest API para Angula")
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
	}

}
