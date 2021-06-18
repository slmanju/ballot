package com.slmanju.ballot.vote.infrastructure.adapter;

import com.slmanju.ballot.vote.domain.event.VotedEvent;
import com.slmanju.ballot.vote.domain.port.out.EventPublisher;
import com.slmanju.ballot.voteresult.domain.port.in.VoteEventListener;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventPublisherAdapter implements EventPublisher {

  private final VoteEventListener VoteEventListener; // Temp

  @Override
  public void publishVoted(VotedEvent votedEvent) {
    System.out.println("Event fired....");
    VoteEventListener.receiveVote(votedEvent);
  }

}
