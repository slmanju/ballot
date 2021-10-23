package com.slmanju.ballot.user.rest;

import com.slmanju.ballot.user.rest.dto.UserRequest;
import com.slmanju.ballot.user.rest.dto.UserView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserApi {

  @PostMapping(value = "/voters")
  ResponseEntity<String> save(@RequestBody UserRequest userRequest);

  @GetMapping(value = "/voters/{id}")
  ResponseEntity<UserView> getPoll(@PathVariable("id") String id);

}
