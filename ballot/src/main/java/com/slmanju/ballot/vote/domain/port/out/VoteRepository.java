package com.slmanju.ballot.vote.domain.port.out;

import com.slmanju.ballot.vote.domain.entity.Vote;

import java.util.List;

public interface VoteRepository {

  void save(Vote vote);

  List<Vote> findByPollId(String pollId);

}
