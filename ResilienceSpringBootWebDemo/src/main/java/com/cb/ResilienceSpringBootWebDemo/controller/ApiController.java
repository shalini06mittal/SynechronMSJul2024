package com.cb.ResilienceSpringBootWebDemo.controller;

import com.cb.ResilienceSpringBootWebDemo.api.ExternalAPICaller;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/")
public class ApiController {

    @Autowired
    private ExternalAPICaller externalAPICaller;

    private static final String circuitBreaker = "example";

    @GetMapping("/circuit-breaker")
    @CircuitBreaker(name = circuitBreaker)
    public String circuitBreakerApi() {
        return externalAPICaller.callApi();
    }
    @GetMapping("/circuit-breaker/{delay}")
    @CircuitBreaker(name = circuitBreaker)
    public String circuitBreakerApiSLowCallRate(@PathVariable long delay) {
        return externalAPICaller.callApiSlowRate(delay);
    }

    @GetMapping("/retry/{message}")
    @Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")
    public String retryApi(@PathVariable String message) {
        return externalAPICaller.callApiRetry(message);
    }

    @GetMapping("/time-limiter")
    @TimeLimiter(name = "timeLimiterApi")
    public CompletableFuture<String> timeLimiterApi() {
        return CompletableFuture.supplyAsync(externalAPICaller::callApiWithDelay);
    }

    @GetMapping("/bulkhead")
    @Bulkhead(name = "bulkheadApi")
    public String bulkheadApi() {
        return externalAPICaller.callApi();
    }

    @GetMapping("/rate-limiter")
    @RateLimiter(name = "rateLimiterApi")
    public String rateLimitApi() {
        return externalAPICaller.callApi();
    }

    public String fallbackAfterRetry(Exception ex) {
        return "all retries have exhausted";
    }

}
