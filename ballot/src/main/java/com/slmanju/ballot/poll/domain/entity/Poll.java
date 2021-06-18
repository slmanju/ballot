package com.slmanju.ballot.poll.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data @Builder
public class Poll {

  private String id;
  private String owner;
  private String question;
  private List<Choice> choices;

  public void addChoice(Choice choice) {
    this.choices.add(choice);
  }

  public void addChoices(List<Choice> choices) {
    this.choices.addAll(choices);
  }

}
