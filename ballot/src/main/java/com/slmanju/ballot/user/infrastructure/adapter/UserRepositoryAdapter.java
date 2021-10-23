package com.slmanju.ballot.user.infrastructure.adapter;

import com.slmanju.ballot.user.domain.entity.User;
import com.slmanju.ballot.user.domain.port.out.UserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepositoryAdapter implements UserRepository {

  private Map<String, User> voters = new HashMap<>();

  @Override
  public void save(User user) {
    voters.put(user.getId(), user);
  }

  @Override
  public User findById(String id) {
    return voters.get(id);
  }

}
