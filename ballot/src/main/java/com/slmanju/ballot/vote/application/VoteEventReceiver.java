package com.slmanju.ballot.vote.application;

import com.slmanju.ballot.vote.domain.event.VotedEvent;
import com.slmanju.ballot.vote.domain.port.in.VoteEventListener;
import com.slmanju.ballot.vote.domain.port.in.VoteResultService;
import com.slmanju.ballot.vote.domain.value.Vote;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VoteEventReceiver implements VoteEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(VoteEventReceiver.class);

  private final VoteResultService voteResultService;

  @Override
  @JmsListener(destination = "${spring.jms.template.default-destination}")
  public void onVote(@Payload VotedEvent votedEvent) {
    LOGGER.info("Received message='{}'", votedEvent);
    Vote vote = new Vote(votedEvent.getPoll(), votedEvent.getChoice(), votedEvent.getVoter());
    voteResultService.vote(vote);
  }

}
