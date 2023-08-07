package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Clicks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsRepo extends JpaRepository<Clicks, Long> {

}
