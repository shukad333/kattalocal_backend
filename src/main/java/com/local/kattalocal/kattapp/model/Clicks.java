package com.local.kattalocal.kattapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.Date;

@Entity
public class Clicks {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Business business;

  private Offer offer;

  private Events events;

  private User user;

  private Date visited;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Business getBusiness() {
    return business;
  }

  public void setBusiness(Business business) {
    this.business = business;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

  public Events getEvents() {
    return events;
  }

  public void setEvents(Events events) {
    this.events = events;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getVisited() {
    return visited;
  }

  public void setVisited(Date visited) {
    this.visited = visited;
  }
}
