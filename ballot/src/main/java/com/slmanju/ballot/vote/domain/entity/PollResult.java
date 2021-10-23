package com.slmanju.ballot.vote.domain.entity;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.vote.domain.value.ChoiceResult;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PollResult {

  private String id;
  private String pollId;
  private String owner;
  private String question;
  private List<ChoiceResult> choiceResults = new ArrayList<>();

  public static PollResult emptyResult(Poll poll) {
    PollResult pollResult = new PollResult();
    pollResult.setId(UUID.randomUUID().toString());
    pollResult.setPollId(poll.getId());
    pollResult.setOwner(poll.getOwner());
    pollResult.setQuestion(poll.getQuestion());
    pollResult.setChoiceResults(ChoiceResult.allZero(poll.getChoices()));
    return pollResult;
  }
}
