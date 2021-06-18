package com.slmanju.ballot.voteresult.domain.port.in;

import com.slmanju.ballot.voteresult.domain.entity.PollResult;
import com.slmanju.ballot.voteresult.domain.value.ResultVote;

public interface VoteResultService {

  void vote(ResultVote vote);

  PollResult findVoteResult(String pollId);

}
