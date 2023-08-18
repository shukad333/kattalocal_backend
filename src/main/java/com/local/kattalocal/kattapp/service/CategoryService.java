package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.Category;
import com.local.kattalocal.kattapp.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;

  public Category findByName(String name) {

    return categoryRepo.findByName(name);
  }


}
