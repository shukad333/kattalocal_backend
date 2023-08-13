package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Clicks;
import com.local.kattalocal.kattapp.model.Events;
import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.repository.AnalyticsRepo;
import com.local.kattalocal.kattapp.util.AnalyticsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AnalyticsService {

  private OfferService offerService;
  private EventsService eventsService;
  private BusinessService businessService;

  private AnalyticsRepo analyticsRepo;

  private AnalyticsValidator analyticsValidator;

  @Autowired
  public AnalyticsService(BusinessService businessService, OfferService offerService,
      EventsService eventsService, AnalyticsRepo analyticsRepo,AnalyticsValidator analyticsValidator) {

    this.businessService = businessService;
    this.offerService = offerService;
    this.eventsService = eventsService;
    this.analyticsRepo = analyticsRepo;
    this.analyticsValidator = analyticsValidator;
  }

  public Clicks save(Clicks clicks, Long businessId, Long offerId, Long eventId) {

    log.debug("Saving analytics {} business {} , offer {} , event {}", clicks, businessId, offerId,
        eventId);
    Business business = businessService.findBusiness(businessId);
    Offer offer = null;
    if (offerId != null) {
      offer = offerService.findOfferById(offerId);
    }
    Events events = null;
    if (eventId != null) {
      events = eventsService.findEventsById(eventId);
    }

    clicks.setBusiness(business);
    clicks.setOffer(offer);
    clicks.setEvents(events);

    return analyticsRepo.save(clicks);

  }

}
