package com.slmanju.ballot.user.domain.api;

import com.slmanju.ballot.user.domain.entity.User;
import com.slmanju.ballot.user.domain.port.in.UserService;
import com.slmanju.ballot.user.domain.port.out.UserRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Override
  public String save(User user) {
    user.setId(UUID.randomUUID().toString());
    userRepository.save(user);
    return user.getId();
  }

  @Override
  public User findById(String id) {
    return userRepository.findById(id);
  }

}
