package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

  @Autowired
  private BusinessRepo businessRepo;

  private PagingAndSortingRepository pagingAndSortingRepository;

  public Business createNew(Business business) {
        business.setActive(true);
        return businessRepo.save(business);

  }

  public List<Business> getAllBusinesses() {
      return businessRepo.findAll();
  }

  public void deactivateBusiness(Long businessId) {
    updateBusinessStatus(businessId,false);
  }

  private void updateBusinessStatus(Long businessId,boolean status) {
    Optional<Business> businessOptional = businessRepo.findById(businessId);
    if(businessOptional.isPresent()) {
      Business business = businessOptional.get();
      business.setActive(status);
      businessRepo.save(business);
    }
  }

}
