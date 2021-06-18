package com.slmanju.ballot.voter.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class VoterView {

  private String id;
  private String alias;
  private String email;

}
