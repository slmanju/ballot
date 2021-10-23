package com.slmanju.ballot.vote.domain.port.out;

import com.slmanju.ballot.vote.domain.entity.PollResult;

public interface WebSocketService {

  void sendResult(PollResult voteResult);

}
