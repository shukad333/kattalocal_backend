package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

  @Autowired private OfferRepository offerRepository;
  public Offer save(Offer offer) {
    return offerRepository.save(offer);
  }

}
