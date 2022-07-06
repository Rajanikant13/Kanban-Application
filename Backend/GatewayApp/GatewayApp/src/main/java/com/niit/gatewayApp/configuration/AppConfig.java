package com.niit.gatewayApp.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
public RouteLocator getRoute(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(r->r.path("/auth/**")
                        .uri("http://localhost:9012/"))
                .route(r->r.path("/kanban/v1/**")
                        .uri("http://localhost:6655/"))
                .route(r->r.path("/user/**")
                        .uri("http://localhost:6655/"))
                .build();
    }
}
