package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessService {

  @Autowired
  private BusinessRepo businessRepo;

  private PagingAndSortingRepository pagingAndSortingRepository;

  public Business createNew(Business business) {
    log.debug("Creating new business {}", business);
    business.setActive(true);
    return businessRepo.save(business);

  }

  public List<Business> getAllBusinesses() {
    return businessRepo.findAll();
  }

  public void deactivateBusiness(Long businessId) {
    log.debug("Deactivating business {}", businessId);
    updateBusinessStatus(businessId, false);
  }

  private void updateBusinessStatus(Long businessId, boolean status) {
    log.debug("Updating business {} to status {}", businessId, status);
    Optional<Business> businessOptional = businessRepo.findById(businessId);
    if (businessOptional.isPresent()) {
      Business business = businessOptional.get();
      business.setActive(status);
      businessRepo.save(business);
    }
  }

}
