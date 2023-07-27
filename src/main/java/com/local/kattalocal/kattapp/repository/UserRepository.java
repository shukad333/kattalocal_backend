package com.local.kattalocal.kattapp.repository;

import com.local.kattalocal.kattapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  @Query(nativeQuery = true, value = "SELECT * from User u WHERE o.user_name=:userName")
  public User findByUserName(@Param("userName") String userName);

}
