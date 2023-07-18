package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Business;
import com.local.kattalocal.kattapp.repository.BusinessRepo;
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

}
