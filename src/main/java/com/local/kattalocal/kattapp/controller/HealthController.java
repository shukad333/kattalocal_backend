package com.local.kattalocal.kattapp.controller;

import com.local.kattalocal.kattapp.model.Health;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

  @GetMapping("/health")
  public ResponseEntity<Health> getHealthStatus() {
    return ResponseEntity.ok(new Health("Success"));
  }

}
