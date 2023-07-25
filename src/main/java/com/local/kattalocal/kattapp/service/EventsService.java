package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.model.Events;
import com.local.kattalocal.kattapp.model.projection.NearByEvents;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
import com.local.kattalocal.kattapp.repository.EventsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventsService {

  @Autowired private EventsRepository eventsRepository;
  @Autowired private BusinessRepo businessRepo;

  public Events save(long businessId , Events events) {
    Business business = businessRepo.findById(businessId).get();
    events.setBusiness(business);
    events.setActive(true);
    return eventsRepository.save(events);
  }

  public List<Events> getEventsForBusiness(long businessId) {
    return eventsRepository.findByBusinessId(businessId);
  }

  public List<NearByEvents> getNearByEvents(double lat , double lon) {
    return eventsRepository.findNearByEvents(lat,lon);
  }


}
