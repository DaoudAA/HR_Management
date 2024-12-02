package com.papillon.rhmanagement.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Employee Management API",
        version = "1.0",
        description = "API for managing employees",
        contact = @Contact(name = "Papillon", email = "contact@papillon.com"),
        license = @License(name = "MIT", url = "https://opensource.org/licenses/MIT")
    ),
    servers = {
        @Server(url = "http://localhost:8080", description = "Local server")
    }
)
public class OpenApiConfig {
    // This class configures the OpenAPI specification for your app
}
