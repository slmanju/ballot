package com.slmanju.ballot.poll.domain.port.out;

import com.slmanju.ballot.poll.domain.entity.Vote;

import java.util.List;

public interface VoteRepository {

  void save(Vote vote);

  List<Vote> findByPollId(String pollId);

}
