package com.slmanju.ballot.voter.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class VoterRequest {

  private String alias;
  private String email;

}
