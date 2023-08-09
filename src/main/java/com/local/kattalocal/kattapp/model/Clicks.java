package com.local.kattalocal.kattapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Date;

@Entity(name = "clicks")
public class Clicks {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @ManyToOne
  @JoinColumn(name = "business_id", referencedColumnName = "id")
  private Business business;

  @ManyToOne
  @JoinColumn(name = "offer_id", referencedColumnName = "id")
  private Offer offer;

  @ManyToOne
  @JoinColumn(name = "events_id", referencedColumnName = "id")
  private Events events;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
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
