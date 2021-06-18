package com.slmanju.ballot.vote.domain.port.out;

import com.slmanju.ballot.vote.domain.event.VotedEvent;

public interface EventPublisher {

  void publishVoted(VotedEvent votedEvent);

}
