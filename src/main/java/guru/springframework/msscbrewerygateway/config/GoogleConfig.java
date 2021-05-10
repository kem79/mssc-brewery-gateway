package guru.springframework.msscbrewerygateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Created by marecm on 5/10/2021
 */
//@Profile("google")
//@Configuration
public class GoogleConfig {

    @Bean
    public RouteLocator googleRouteConfig(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/googlesearch2")
                        .filters(f-> f.rewritePath("/googlesearch2(?<segment>/?.*)", "/${segment}"))
                    .uri("https://www.google.com.hk")
                )
                .build();
    }
}
