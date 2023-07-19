package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {



}
