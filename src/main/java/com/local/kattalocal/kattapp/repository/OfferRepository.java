package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Offer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {


  @Query(nativeQuery = true,value = "SELECT * from Offer o WHERE o.business_id=:businessId")
  List<Offer> findByBusinessId(@Param("businessId") Long businessId);

}
