package com.slmanju.ballot.poll.domain.application;

import com.slmanju.ballot.poll.domain.event.VotedEvent;
import com.slmanju.ballot.poll.domain.port.in.VotedEventListener;
import com.slmanju.ballot.poll.domain.port.in.PollResultService;
import com.slmanju.ballot.poll.domain.value.Vote;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VotedEventReceiver implements VotedEventListener {

  private static final Logger LOGGER = LoggerFactory.getLogger(VotedEventReceiver.class);

  private final PollResultService pollResultService;

  @Override
  @JmsListener(destination = "${spring.jms.template.default-destination}")
  public void onVote(@Payload VotedEvent votedEvent) {
    LOGGER.info("Received message='{}'", votedEvent);
    Vote vote = new Vote(votedEvent.getPoll(), votedEvent.getChoice(), votedEvent.getVoter());
    pollResultService.onVoteReceived(vote);
  }

}
