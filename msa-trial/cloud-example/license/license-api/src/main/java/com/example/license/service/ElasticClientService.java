package com.example.license.service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class ElasticClientService {

  @Retry(name = "myRetry", fallbackMethod = "fallbackMethod")
  @Bulkhead(name = "myThreadPoolBulkhead", type = Bulkhead.Type.THREADPOOL, fallbackMethod = "fallbackMethod")
  @CircuitBreaker(name = "myService", fallbackMethod = "fallbackMethod")
  @RateLimiter(name = "myRateLimiter", fallbackMethod = "fallbackMethod")
  public String callExternalApi(String param) {
    return "Response from external API for " + param;
  }

  public String fallbackMethod(String param, Throwable t) {
    return "Retry fallback response for " + param + ": " + t.getMessage();
  }
}
