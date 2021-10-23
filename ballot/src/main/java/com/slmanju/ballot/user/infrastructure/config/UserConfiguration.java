package com.slmanju.ballot.user.infrastructure.config;

import com.slmanju.ballot.user.domain.port.in.UserService;
import com.slmanju.ballot.user.domain.port.out.UserRepository;
import com.slmanju.ballot.user.domain.api.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

  @Bean
  public UserService voterService(UserRepository userRepository) {
    return new UserServiceImpl(userRepository);
  }

}
