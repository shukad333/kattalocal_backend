package com.local.kattalocal.kattapp.util;

import com.local.kattalocal.kattapp.model.Clicks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AnalyticsValidator {

  public boolean validateClicks(Long businessId, Long offerId, Long eventId) {
    if (businessId == null) {
      log.error("Business Id cannot be null");
      return false;
    }
    if (offerId != null && eventId != null) {
      log.error("Both offer and events cannot be present");
      return false;
    }
    if (offerId == null && eventId == null) {
      log.error("Need atleast one of offer or event");
      return false;
    }

    return true;
  }

}
