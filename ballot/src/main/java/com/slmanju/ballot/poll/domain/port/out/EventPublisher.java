package com.slmanju.ballot.poll.domain.port.out;

import com.slmanju.ballot.poll.domain.event.VotedEvent;

public interface EventPublisher {

  void publishVotedEvent(VotedEvent votedEvent);

}
