package com.slmanju.ballot.user.rest.controller;

import com.slmanju.ballot.user.domain.entity.User;
import com.slmanju.ballot.user.domain.port.in.UserService;
import com.slmanju.ballot.user.rest.UserApi;
import com.slmanju.ballot.user.rest.dto.UserRequest;
import com.slmanju.ballot.user.rest.dto.UserView;
import com.slmanju.ballot.user.rest.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController implements UserApi {

  private final UserService userService;
  private final UserMapper userMapper;

  @Override
  public ResponseEntity<String> save(UserRequest userRequest) {
    String id = userService.save(userMapper.toUser(userRequest));
    return ResponseEntity.ok(id);
  }

  @Override
  public ResponseEntity<UserView> getPoll(String id) {
    User user = userService.findById(id);
    UserView userView = userMapper.toView(user);
    return ResponseEntity.ok(userView);
  }

}
