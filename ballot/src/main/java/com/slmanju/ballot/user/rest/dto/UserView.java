package com.slmanju.ballot.user.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class UserView {

  private String id;
  private String alias;
  private String email;

}
