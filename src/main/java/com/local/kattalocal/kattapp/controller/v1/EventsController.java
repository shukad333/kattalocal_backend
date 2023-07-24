package com.local.kattalocal.kattapp.controller.v1;

import com.local.kattalocal.kattapp.model.Events;
import com.local.kattalocal.kattapp.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

  @Autowired private EventsService eventsService;

  @PostMapping(value = "v1/{businessId}/events")
  public ResponseEntity<Events> newEvent(@PathVariable("businessId") long businessId , @RequestBody Events events) {
    return new ResponseEntity<>(eventsService.save(businessId,events), HttpStatus.CREATED);
  }


}
