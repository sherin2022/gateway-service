package com.example.demo.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder.routes()
                .route("authentication-authorization-service", rt -> rt.path("/api/v1/auth/login")
                        .uri("http://host.docker.internal:3000/"))
                .route("authentication-authorization-service", rt -> rt.path("/api/v1/auth/signup")
                        .uri("http://host.docker.internal:3000/"))
                .route("user-service", rt -> rt.path("/api/v1/users/**")
                        .uri("http://host.docker.internal:3005/"))
                .route("post-service", rt -> rt.path("/api/v1/posts/**")
                        .uri("http://host.docker.internal:3010/"))
                .route("comment-service", rt -> rt.path("/api/v1/posts/*/comments/**")
                        .uri("http://host.docker.internal:3015/"))
                .route("like-service", rt -> rt.path("/api/v1/postsOrComments/**")
                        .uri("http://host.docker.internal:3020/"))

                .build();
    }
}
