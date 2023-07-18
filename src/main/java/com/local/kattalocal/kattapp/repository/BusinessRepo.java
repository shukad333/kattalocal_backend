package com.local.kattalocal.kattapp.repository;


import com.local.kattalocal.kattapp.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface BusinessRepo extends JpaRepository<Business,Long> {



}
