package com.slmanju.ballot.poll.rest.mapper;

import com.slmanju.ballot.poll.domain.entity.Choice;
import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.rest.dto.ChoiceView;
import com.slmanju.ballot.poll.rest.dto.PollRequest;
import com.slmanju.ballot.poll.rest.dto.PollView;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class PollMapper {

  public Poll toCreatePoll(PollRequest pollRequest) {
    return Poll.builder()
      .owner(pollRequest.getOwner())
      .question(pollRequest.getQuestion())
      .choices(toChoices(pollRequest.getChoices()))
      .build();
  }

  private List<Choice> toChoices(List<ChoiceView> choices) {
    return choices.stream()
      .map(choiceView -> new Choice(choiceView.getChoice()))
      .collect(toList());
  }

  public PollView fromPoll(Poll poll) {
    return PollView.builder()
      .id(poll.getId())
      .owner(poll.getOwner())
      .question(poll.getQuestion())
      .choices(toChoiceView(poll.getChoices()))
      .build();
  }

  private List<ChoiceView> toChoiceView(List<Choice> choices) {
    return choices.stream()
      .map(choice -> new ChoiceView(choice.getChoice()))
      .collect(toList());
  }

}
