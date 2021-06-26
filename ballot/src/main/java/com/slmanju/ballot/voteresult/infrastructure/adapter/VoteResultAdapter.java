package com.slmanju.ballot.voteresult.infrastructure.adapter;

import com.slmanju.ballot.voteresult.domain.port.out.VoteResultRepository;
import com.slmanju.ballot.voteresult.domain.value.ResultVote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VoteResultAdapter implements VoteResultRepository {

  @Autowired
  private VoteResultCacheManager voteResultCacheManager;

  @Override
  public void saveVote(ResultVote vote) {
    voteResultCacheManager.put(vote);
  }

  @Override
  public List<ResultVote> findAllById(String pollId) {
    return voteResultCacheManager.find(pollId);
  }

}
