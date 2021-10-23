package com.slmanju.ballot.vote.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Vote in the vote-result sub domain.
 */
@Getter @NoArgsConstructor @AllArgsConstructor
public class Vote {

  private String pollId;
  private String choice;
  private String voter;

}
