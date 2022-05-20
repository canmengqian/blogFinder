package com.zzz.media.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className GateWayConfig
 * @description TODO
 * @date 2022/5/18
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("path_route", r -> r.path("/csdn")
                        .uri("https://blog.csdn.net"))
                .route("baidu", r ->
                        r.path("/baidu").uri("http://www.51cto.com"))
                .build();
    }
}
