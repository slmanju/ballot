package com.slmanju.ballot.voteresult.domain.port.out;

import com.slmanju.ballot.voteresult.domain.value.ResultVote;

import java.util.List;

public interface VoteResultRepository {

  void saveVote(ResultVote vote);

  List<ResultVote> findAllById(String pollId);

}
