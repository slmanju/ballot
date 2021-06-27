package com.slmanju.ballot.vote.domain.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data @AllArgsConstructor
public class VotedEvent implements Serializable {

  private String poll;
  private String voter;
  private String choice;

}
