package com.slmanju.ballot.user.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class User {

  private String id;
  private String alias;
  private String email;

}
