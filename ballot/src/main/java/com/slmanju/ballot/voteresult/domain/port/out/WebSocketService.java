package com.slmanju.ballot.voteresult.domain.port.out;

import com.slmanju.ballot.voteresult.domain.entity.PollResult;

public interface WebSocketService {

  void sendResult(PollResult voteResult);

}
