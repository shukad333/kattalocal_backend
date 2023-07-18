package com.local.kattalocal.kattapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.local.kattalocal.kattapp")
@ComponentScan("com.local.kattalocal.kattapp")
@EnableJpaRepositories("com.local.kattalocal.kattapp")
public class KattappApplication {

  public static void main(String[] args) {
    SpringApplication.run(KattappApplication.class, args);
  }

}
