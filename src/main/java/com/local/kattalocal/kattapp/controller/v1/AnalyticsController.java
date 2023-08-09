package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Clicks;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalyticsController {

  @PostMapping("/v1/analytics")
  public ResponseEntity<Clicks> newAnalytics() {
    return null;
  }

  @GetMapping("/v1/analytics")
  public ResponseEntity<List<Clicks>> getAllAnalytics() {
    return null;
  }

}
