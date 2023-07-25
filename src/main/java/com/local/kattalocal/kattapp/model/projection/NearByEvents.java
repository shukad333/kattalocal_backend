package com.local.kattalocal.kattapp.model.projection;

import jakarta.persistence.Column;
import java.sql.Date;

public interface NearByEvents {

  String getTitle();
  String getDescription();
  Date getStartDate();
  Date getEndDate();
  String getDistance();
  boolean getIsActive();

}
