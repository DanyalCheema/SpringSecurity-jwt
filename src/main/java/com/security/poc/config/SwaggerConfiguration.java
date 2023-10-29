package com.security.poc.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author by Danyal
 * @classname SwaggerConfiguration
 * @Date 30/10/2023 12:08 am
 */

@OpenAPIDefinition(
  info = @Info(
    contact = @Contact(
      name = "Danyal",
      email = "mr.danyalcheema@gmail.com"
    ),
    description = "Spring Security Documentation",
    title = "OpenApi specification - Danyal",
    version = "1.0"
  ),
  servers = {
    @Server(
      description = "Local ENV",
      url = "http://localhost:8080"
    )
  }
)
public class SwaggerConfiguration {


}
