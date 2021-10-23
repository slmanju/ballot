package com.slmanju.ballot.user.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserRequest {

  private String alias;
  private String email;

}
