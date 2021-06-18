package com.slmanju.ballot.poll.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class PollRequest {

  private String owner;
  private String question;
  private List<ChoiceView> choices = new ArrayList<>();

}
