package com.slmanju.ballot.user.domain.port.out;

import com.slmanju.ballot.user.domain.entity.User;

public interface UserRepository
{

  void save(User user);

  User findById(String id);

}
