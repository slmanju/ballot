package com.slmanju.ballot.vote.domain.port.out;

import com.slmanju.ballot.vote.domain.value.Vote;

import java.util.List;

public interface VoteResultRepository {

  void saveVote(Vote vote);

  List<Vote> findAllById(String pollId);

}
