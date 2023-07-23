package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
import com.local.kattalocal.kattapp.repository.OfferRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

  @Autowired private OfferRepository offerRepository;
  @Autowired private BusinessRepo businessRepo;
  public Offer save(Offer offer,Long businessId) {
    Business business = businessRepo.findById(businessId).get();
    offer.setBusiness(business);
    return offerRepository.save(offer);
  }

  public List<Offer> getOffersForBusiness(Long businessId) {

      return offerRepository.findByBusinessId(businessId);
  }

  public List<NearByOffers> getNearByOffers(double lat , double lon) {
    return offerRepository.findNearByOffers(lat,lon);
  }

}
