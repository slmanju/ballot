package com.slmanju.ballot.user.rest.mapper;

import com.slmanju.ballot.user.domain.entity.User;
import com.slmanju.ballot.user.rest.dto.UserRequest;
import com.slmanju.ballot.user.rest.dto.UserView;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toUser(UserRequest userRequest) {
    return User.builder()
      .alias(userRequest.getAlias())
      .email(userRequest.getEmail())
      .build();
  }

  public UserView toView(User user) {
    return UserView.builder()
      .id(user.getId())
      .alias(user.getAlias())
      .email(user.getEmail())
      .build();
  }

}
