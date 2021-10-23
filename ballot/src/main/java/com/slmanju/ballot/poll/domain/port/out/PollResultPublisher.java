package com.slmanju.ballot.poll.domain.port.out;

import com.slmanju.ballot.poll.domain.entity.PollResult;

public interface PollResultPublisher {

  void publishResult(PollResult voteResult);

}
