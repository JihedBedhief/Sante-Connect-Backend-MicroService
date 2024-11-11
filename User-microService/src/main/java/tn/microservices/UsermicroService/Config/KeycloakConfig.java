package tn.microservices.UsermicroService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.keycloak.admin.client.Keycloak;

@Configuration
public class KeycloakConfig {

    @Bean
    public Keycloak keycloak() {
        // Create and configure a Keycloak instance
        return Keycloak.getInstance("http://localhost:8080/", "micro-services", "admin", "admin", "pidev-client-ang");
    }
}
