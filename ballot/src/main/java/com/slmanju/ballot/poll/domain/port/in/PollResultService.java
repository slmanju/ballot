package com.slmanju.ballot.poll.domain.port.in;

import com.slmanju.ballot.poll.domain.entity.PollResult;
import com.slmanju.ballot.poll.domain.value.Vote;

public interface PollResultService {

  void onVoteReceived(Vote vote);

  PollResult findPollResult(String pollId);

}
