package com.ssharaev.webauthnexample.service;


import com.ssharaev.webauthnexample.model.UserEntity;
import com.ssharaev.webauthnexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
      return userRepository.findByUsername(username).orElseThrow();
  }

  public void createUser(String username, String password) {
      UserEntity user = new UserEntity();
      user.setUsername(username);
      user.setPassword(password);
      userRepository.save(user);
  }
}

