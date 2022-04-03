package com.example.demo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class RouteConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route("user-service", rt -> rt.path("/users/**")
                        .uri("http://localhost:3005/"))
                .route("comment-service",rt -> rt.path("/posts/*/comments/**")
                .uri("http://localhost:3015/"))
                .route("post-service",rt -> rt.path("/posts/**")
                        .uri("http://localhost:3010/"))

                .route("like-service",rt -> rt.path("/postsOrComments/**")
                        .uri("http://localhost:3020/"))
                .route("authentication-authorization-service", rt -> rt.path("/auth/**")
                        .uri("http://localhost:3000/"))
                .build();

    }
}
