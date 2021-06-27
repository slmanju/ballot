package com.slmanju.ballot.voteresult.domain.port.in;

import com.slmanju.ballot.voteresult.domain.entity.PollResult;
import com.slmanju.ballot.voteresult.domain.value.Vote;

public interface VoteResultService {

  void vote(Vote vote);

  PollResult findVoteResult(String pollId);

}
