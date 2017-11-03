package com.spotify.springBootExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan(basePackages = {"com.spotify.springBootExample"})
@ComponentScan(basePackages = {"com.spotify.springBootExample"})
@ImportResource(value={"classpath*:legacy-context.xml"})
public class ServiceRunner {

  public static void main(String[] args) {
    SpringApplication.run(ServiceRunner.class, args);
  }

  @RequestMapping("/home")
  String home() {
    return "Hello World!";
  }
}
