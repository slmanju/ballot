package com.slmanju.ballot.vote.domain.port.in;

import com.slmanju.ballot.vote.domain.entity.PollResult;
import com.slmanju.ballot.vote.domain.value.Vote;

public interface VoteResultService {

  void vote(Vote vote);

  PollResult findVoteResult(String pollId);

}
