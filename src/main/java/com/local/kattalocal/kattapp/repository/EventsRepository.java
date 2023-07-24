package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events,Long> {



}
