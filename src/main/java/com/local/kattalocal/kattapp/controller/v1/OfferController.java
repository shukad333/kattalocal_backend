package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

  @Autowired
  private OfferService offerService;

  @PostMapping("v1/offers")
  public ResponseEntity<Offer> addNewOffer(@RequestBody Offer offer) {

    return new ResponseEntity<>(offerService.save(offer), HttpStatus.CREATED);

  }


}