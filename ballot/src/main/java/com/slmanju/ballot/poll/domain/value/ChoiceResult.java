package com.slmanju.ballot.poll.domain.value;

import com.slmanju.ballot.poll.domain.entity.Choice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ChoiceResult {

  private String choice;
  private int votes;

  public void increment() {
    this.votes = votes + 1;
  }

  public ChoiceResult vote() {
    return new ChoiceResult(choice, votes + 1);
  }

  public static ChoiceResult zero(String choice) {
    return new ChoiceResult(choice, 0);
  }

  public static List<ChoiceResult> allZero(List<Choice> choices) {
    List<ChoiceResult> choiceResults = new ArrayList<>();
    for (Choice choice : choices) {
      choiceResults.add(ChoiceResult.zero(choice.getChoice()));
    }
    return choiceResults;
  }

}
