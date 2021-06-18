package com.slmanju.ballot.voteresult.domain.value;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @NoArgsConstructor @AllArgsConstructor
public class ResultVote {

  private String pollId;
  private String choice;
  private String voter;

}
