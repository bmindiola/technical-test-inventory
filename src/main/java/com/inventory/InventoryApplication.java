package com.inventory;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("--- API Documentation ---")
						.version("1")
						.description("API documentation with OpenApi and Swagger"));
	}

}
