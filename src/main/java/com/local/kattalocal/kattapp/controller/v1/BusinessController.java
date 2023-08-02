package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Health;
import com.local.kattalocal.kattapp.service.BusinessService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BusinessController {

  @Autowired
  private BusinessService businessService;

  @PostMapping(path = "/v1/business")
  public ResponseEntity<Business> newBusiness(@RequestBody Business business) {
    log.debug("Creating new business {}", business);
    return new ResponseEntity<>(businessService.createNew(business), HttpStatus.CREATED);


  }

  @GetMapping("/v1/business")
  public ResponseEntity<List<Business>> getBusiness() {
    log.debug("getting all businesses");
    return ResponseEntity.ok(businessService.getAllBusinesses());
  }

  @PutMapping("/v1/business/{businessId}/deactivate")
  public ResponseEntity<Void> deactivateBusiness(@PathVariable Long businessId) {
    log.debug("Deactivating business {}", businessId);
    businessService.deactivateBusiness(businessId);
    return ResponseEntity.ok(null);
  }

}
