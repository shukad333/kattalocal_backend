package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import com.local.kattalocal.kattapp.model.request.Image;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
import com.local.kattalocal.kattapp.repository.OfferRepository;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OfferService {

  @Autowired
  private OfferRepository offerRepository;
  @Autowired
  private BusinessRepo businessRepo;

  public Offer save(Offer offer, Long businessId) {
    Business business = businessRepo.findById(businessId).get();
    offer.setBusiness(business);
    return offerRepository.save(offer);
  }

  public List<Offer> getOffersForBusiness(Long businessId) {

    return offerRepository.findByBusinessId(businessId);
  }

  public List<NearByOffers> getNearByOffers(double lat, double lon) {
    return offerRepository.findNearByOffers(lat, lon);
  }

  public List<NearByOffers> getNearByOffers(double lat, double lon, int page, int size) {
    Pageable pageable = PageRequest.of(page, size);
    return offerRepository.findNearByOffersWithPagination(lat, lon, pageable);
  }

  public Offer findOfferById(Long id) {
    Optional<Offer> optionalOffer = offerRepository.findById(id);
    if (optionalOffer.isPresent()) {
      return optionalOffer.get();
    }
    String message = String.format("No Offer found with id %s", id);
    throw new RuntimeException(message);
  }

  public Offer updateOfferImage(Long id, Image image) {
    log.info("Setting Image {} to offer {}", image.getFilePath(), id);
    Optional<Offer> optionalOffer = offerRepository.findById(id);
    if (optionalOffer.isPresent()) {
      Offer offer = optionalOffer.get();
      offer.setImage(image.getFilePath());
      offerRepository.save(offer);
      return offer;
    }
    String message = String.format("No Offer found with id %s", id);
    throw new RuntimeException(message);
  }

}
