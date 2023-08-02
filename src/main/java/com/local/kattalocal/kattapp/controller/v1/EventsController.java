package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Events;
import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.model.projection.NearByEvents;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import com.local.kattalocal.kattapp.service.EventsService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
public class EventsController {

  @Autowired
  private EventsService eventsService;

  @PostMapping(value = "v1/{businessId}/events")
  public ResponseEntity<Events> newEvent(@PathVariable("businessId") long businessId,
      @RequestBody Events events) {
    log.debug("Creating new events{} for business {}",events,businessId);
    return new ResponseEntity<>(eventsService.save(businessId, events), HttpStatus.CREATED);
  }

  @GetMapping("v1/{businessId}/events")
  public ResponseEntity<List<Events>> getOffersForBusiness(@PathVariable Long businessId) {
    log.debug("Getting all events for business {}",businessId);
    return ResponseEntity.ok(eventsService.getEventsForBusiness(businessId));
  }

  @GetMapping("v1/events/nearby")
  public ResponseEntity<List<NearByEvents>> getNearbyEvents(@RequestParam("latitude") double lat,
      @RequestParam("longitude") double longitude) {
    log.debug("Get events lat - {} long - {}", lat, longitude);
    return ResponseEntity.ok(eventsService.getNearByEvents(lat, longitude));
  }

  @PutMapping("v1/events/{eventId}/invalidate")
  public ResponseEntity<Events> invalidateEvent(@PathVariable("eventId") Long eventId) {
    log.info("Invalidating events {}", eventId);
    return ResponseEntity.ok(eventsService.invalidateEvent(eventId));
  }


}
