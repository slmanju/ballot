package com.slmanju.ballot.voteresult.domain.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ChoiceResult {

  private String choice;
  private int votes;

  public ChoiceResult vote() {
    return new ChoiceResult(choice, votes + 1);
  }

}
