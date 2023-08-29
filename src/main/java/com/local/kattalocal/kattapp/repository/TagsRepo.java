package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepo extends JpaRepository<Tag, Long> {

}
