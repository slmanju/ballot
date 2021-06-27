package com.slmanju.ballot.voteresult.domain.port.out;

import com.slmanju.ballot.voteresult.domain.value.Vote;

import java.util.List;

public interface VoteResultRepository {

  void saveVote(Vote vote);

  List<Vote> findAllById(String pollId);

}
