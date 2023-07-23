package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {


  @Query(nativeQuery = true,value = "SELECT * from Offer o WHERE o.business_id=:businessId")
  List<Offer> findByBusinessId(@Param("businessId") Long businessId);

  @Query(nativeQuery = true,value = "SELECT a.id as businessId,a.name as businessName,b.title,b.description, ( 6371 * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(latitude )))) AS distance FROM business a JOIN Offer b ON a.id=b.business_id HAVING distance < 28 ORDER BY distance LIMIT 0, 20;")
  List<NearByOffers> findNearByOffers(@Param("lat") double lat,@Param("lon") double lon);

}
