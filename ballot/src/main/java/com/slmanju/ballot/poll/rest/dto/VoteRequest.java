package com.slmanju.ballot.poll.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class VoteRequest {

  private String pollId;
  private String choice;
  private String voter;

}
