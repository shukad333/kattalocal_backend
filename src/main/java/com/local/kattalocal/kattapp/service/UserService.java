package com.local.kattalocal.kattapp.service;

import com.local.kattalocal.kattapp.model.User;
import com.local.kattalocal.kattapp.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired private UserRepository userRepository;

  public User findByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }

  public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {

    User user = findByUserName(phoneNumber);

    return new org.springframework.security.core.userdetails.User(user.getPhoneNumber(),null,new ArrayList<>());

  }

}
