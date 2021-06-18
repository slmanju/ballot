package com.slmanju.ballot.voter.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Voter {

  private String id;
  private String alias;
  private String email;

}
