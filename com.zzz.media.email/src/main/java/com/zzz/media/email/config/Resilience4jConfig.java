package com.zzz.media.email.config;

import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className Resilience4jConfig
 * @description TODO
 * @date 2022/5/26
 */
@Configuration
public class Resilience4jConfig {


    /*@Resource
    Resilience4JCircuitBreakerFactory resilience4JCircuitBreakerFactory;

    @Bean
    public Resilience4JCircuitBreakerFactory createResilience4JCircuitBreakerFactory(Resilience4JCircuitBreakerFactory factory) {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .slowCallDurationThreshold(Duration.ofSeconds(60))
                .slowCallRateThreshold(100F)
                .permittedNumberOfCallsInHalfOpenState(10)
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .waitDurationInOpenState(Duration.ofSeconds(30))
                .automaticTransitionFromOpenToHalfOpenEnabled(true).build();

        factory.configure(cb -> {
            cb.circuitBreakerConfig(circuitBreakerConfig).build();
        }, "circuitA", "circuitB");
        return factory;
    }*/
}
