package com.pintuiitbhu.apigateway.configurations;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGateConfiguration {

    @Bean
    RouteLocator gateWayRouter(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route(predicateSpec ->
                    predicateSpec.path("/get")
                            .filters(gatewayFilterSpec -> gatewayFilterSpec
                                    .addRequestHeader("myHeader","header")
                                    .addRequestParameter("reqParam","params"))
                            .uri("http://httpbin.org:80"))
                .route(predicateSpec ->
                        predicateSpec.path("/currency-exchange/**")
                                .uri("lb://currency-exchange"))
                .route(predicateSpec ->
                        predicateSpec.path("/currency-conversion/**")
                                .uri("lb://currency-conversion"))
                .route(predicateSpec ->
                        predicateSpec.path("/currency-conversion-feign/**")
                                .uri("lb://currency-conversion"))
                .route(predicateSpec ->
                        predicateSpec.path("/currency-conversion-new/**")
                                .filters(gatewayFilterSpec -> gatewayFilterSpec
                                        .rewritePath("/currency-conversion-new/(?<segment>.*)",
                                                "/currency-conversion-feign/${segment}"))
                                .uri("lb://currency-conversion"))
                .build();
    }
}
