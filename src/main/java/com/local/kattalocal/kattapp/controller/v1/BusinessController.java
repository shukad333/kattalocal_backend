package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Health;
import com.local.kattalocal.kattapp.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

  @Autowired private BusinessService businessService;

  @PostMapping(path = "/v1/business")
  public ResponseEntity<Business> newBusiness(@RequestBody Business business) {


    return new ResponseEntity<>(businessService.createNew(business), HttpStatus.CREATED);


  }

  @GetMapping("/business")
  public ResponseEntity<Health> getBusiness() {
    return ResponseEntity.ok(new Health("Succ"));
  }

}
