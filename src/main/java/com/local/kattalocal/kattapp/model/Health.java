package com.local.kattalocal.kattapp.model;

import java.util.Date;

public class Health {

  private String status;
  private Date timeStamp;

  public Health(String status) {
    this.status = status;
    timeStamp = new Date();
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public void setTimeStamp(Date timeStamp) {
    this.timeStamp = timeStamp;
  }
}
