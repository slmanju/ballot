package com.slmanju.ballot.vote.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class VotedEvent {

  private String poll;
  private String voter;
  private String choice;

}
