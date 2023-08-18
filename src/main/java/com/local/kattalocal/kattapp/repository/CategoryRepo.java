package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

  @Transactional
  @Query(nativeQuery = true,value = "SELECT * from Category c where c.title=:name")
  public Category findByName(@Param("name") String name);

}
