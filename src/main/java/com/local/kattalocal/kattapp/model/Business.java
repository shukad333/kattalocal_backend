package com.local.kattalocal.kattapp.model;

import com.local.kattalocal.kattapp.model.enums.BusinessStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;

@Entity
@Table(name = "business")
public class Business implements Serializable {

  private static final long serialVersionUID = 432154291451321L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  private String name;
  private String type;

  @jakarta.persistence.Column(name = "license_number")
  private String licenseNumber;

  private Double latitude;
  private Double longitude;

  private String address1;
  private String address2;
  private String address3;

  private String image1;
  private String image2;

  public String getImage1() {
    return image1;
  }

  public void setImage1(String image1) {
    this.image1 = image1;
  }

  public String getImage2() {
    return image2;
  }

  public void setImage2(String image2) {
    this.image2 = image2;
  }

  @Enumerated(EnumType.STRING)
  @Column(name = "business_status")
  private BusinessStatus businessStatus;

  public BusinessStatus getBusinessStatus() {
    return businessStatus;
  }

  public void setBusinessStatus(BusinessStatus businessStatus) {
    this.businessStatus = businessStatus;
  }

  public String getAddress1() {
    return address1;
  }

  public void setAddress1(String address1) {
    this.address1 = address1;
  }

  public String getAddress2() {
    return address2;
  }

  public void setAddress2(String address2) {
    this.address2 = address2;
  }

  public String getAddress3() {
    return address3;
  }

  public void setAddress3(String address3) {
    this.address3 = address3;
  }

  public String getLicenseNumber() {
    return licenseNumber;
  }

  public void setLicenseNumber(String licenseNumber) {
    this.licenseNumber = licenseNumber;
  }

  @jakarta.persistence.Column(name = "is_active")
  private boolean isActive;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  @Override
  public String toString() {
    return "Business{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", type='" + type + '\'' +
        ", licenseNumber='" + licenseNumber + '\'' +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        ", address1='" + address1 + '\'' +
        ", address2='" + address2 + '\'' +
        ", address3='" + address3 + '\'' +
        ", isActive=" + isActive +
        '}';
  }
}
