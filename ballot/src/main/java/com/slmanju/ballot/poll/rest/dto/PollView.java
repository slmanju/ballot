package com.slmanju.ballot.poll.rest.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter @Builder
public class PollView {

  private String id;
  private String owner;
  private String question;
  private List<ChoiceView> choices;

}
