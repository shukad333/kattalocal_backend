package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import com.local.kattalocal.kattapp.service.OfferService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController {

  @Autowired
  private OfferService offerService;

  @PostMapping("v1/{businessId}/offers")
  public ResponseEntity<Offer> addNewOffer(@RequestBody Offer offer,@PathVariable Long businessId) {

    return new ResponseEntity<>(offerService.save(offer,businessId), HttpStatus.CREATED);

  }

  @GetMapping("v1/business/{businessId}/offers")
  public ResponseEntity<List<Offer>> getOffersForBusiness(@PathVariable Long businessId) {

    return ResponseEntity.ok(offerService.getOffersForBusiness(businessId));
  }

  @GetMapping("v1/offers/nearby/all")
  public ResponseEntity<List<NearByOffers>> getNearbyOffers(@RequestParam("latitude") double lat , @RequestParam("longitude") double longitude) {
    return ResponseEntity.ok(offerService.getNearByOffers(lat,longitude));
  }

  @GetMapping("v1/offers/nearby")
  public ResponseEntity<List<NearByOffers>> getNearbyOffersPageable(@RequestParam("latitude") double lat , @RequestParam("longitude") double longitude, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) {
    System.out.println("XXXX");
    return ResponseEntity.ok(offerService.getNearByOffers(lat,longitude,pageNumber,pageSize));
  }

  @PutMapping("v1/{businessId}/offers")
  public ResponseEntity<Offer> updateOffer() {
    return null;
  }


}