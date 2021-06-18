package com.slmanju.ballot.vote.domain.port.in;

import com.slmanju.ballot.vote.domain.entity.Vote;

import java.util.List;

public interface VoteService {

  void vote(Vote vote);

  List<Vote> findVotesByPollId(String pollId);

}
