package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Events;
import com.local.kattalocal.kattapp.model.Offer;
import com.local.kattalocal.kattapp.model.projection.NearByEvents;
import com.local.kattalocal.kattapp.model.projection.NearByOffers;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {


  @Query(nativeQuery = true, value = "SELECT * from Events e WHERE e.business_id=:businessId")
  List<Events> findByBusinessId(@Param("businessId") Long businessId);

  @Query(nativeQuery = true, value = "SELECT a.id as businessId,a.name as businessName,b.title,b.description,b.start_date as startDate,b.end_date as endDate,b.is_active as isActive, ( 6371 * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(latitude )))) AS distance FROM business a JOIN events b ON a.id=b.business_id HAVING distance < 28 ORDER BY distance LIMIT 0, 20;")
  List<NearByEvents> findNearByEvents(@Param("lat") double lat, @Param("lon") double lon);


}
