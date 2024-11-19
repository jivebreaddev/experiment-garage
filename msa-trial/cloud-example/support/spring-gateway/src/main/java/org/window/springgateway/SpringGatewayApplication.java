package org.window.springgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
public class SpringGatewayApplication {

  public static void main(String[] args) {
    Hooks.enableAutomaticContextPropagation();

    SpringApplication.run(SpringGatewayApplication.class, args);
  }

}
