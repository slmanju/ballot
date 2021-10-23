package com.slmanju.ballot.poll.domain.port.in;

import com.slmanju.ballot.poll.domain.entity.Vote;

import java.util.List;

public interface VoteService {

  void vote(Vote vote);

  List<Vote> findVotesByPollId(String pollId);

}
