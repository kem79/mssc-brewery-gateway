package guru.springframework.msscbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by marecm on 5/10/2021
 */
@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("beer-service",
                        r-> r.path("/api/v1/beer*", "/api/v1/beer/*", "/api/v1/beerUpc/*")
                                .uri("http://localhost:8080"))
                .route("order-service",
                        r->r.path("/api/v1/customers/**"
                                )
                                .uri("http://localhost:8083"))
                .route("inventory-service",
                        r->r.path("/api/v1/beer/*/inventory"
                                )
                                .uri("http://localhost:8082"))
                .build();
    }
}
