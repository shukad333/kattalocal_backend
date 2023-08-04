package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Events;
import com.local.kattalocal.kattapp.model.projection.NearByEvents;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
import com.local.kattalocal.kattapp.repository.EventsRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventsService {

  @Autowired
  private EventsRepository eventsRepository;
  @Autowired
  private BusinessRepo businessRepo;

  public Events save(long businessId, Events events) {
    log.debug("Saving business {} with events {}", businessId, events);
    Business business = businessRepo.findById(businessId).get();
    events.setBusiness(business);
    events.setActive(true);
    return eventsRepository.save(events);
  }

  public List<Events> getEventsForBusiness(long businessId) {
    log.debug("Getting events for business {}", businessId);
    return eventsRepository.findByBusinessId(businessId);
  }

  public List<NearByEvents> getNearByEvents(double lat, double lon) {
    log.debug("Getting near by events in lat {} and long {}", lat, lon);
    return eventsRepository.findNearByEvents(lat, lon);
  }

  public Events invalidateEvent(Long eventId) {
    log.debug("Invalidating event {}", eventId);
    Events event = eventsRepository.findById(eventId).get();
    event.setActive(false);
    return eventsRepository.save(event);
  }


}
