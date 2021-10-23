package com.slmanju.ballot.user.domain.port.in;

import com.slmanju.ballot.user.domain.entity.User;

public interface UserService
{

  String save(User user);

  User findById(String id);

}
