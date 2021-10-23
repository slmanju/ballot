package com.slmanju.ballot.vote.infrastructure.adapter;

import com.slmanju.ballot.vote.domain.port.out.VoteResultRepository;
import com.slmanju.ballot.vote.domain.value.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VoteResultAdapter implements VoteResultRepository {

  @Autowired
  private VoteResultCacheManager voteResultCacheManager;

  @Override
  public void saveVote(Vote vote) {
    voteResultCacheManager.put(vote);
  }

  @Override
  public List<Vote> findAllById(String pollId) {
    return voteResultCacheManager.find(pollId);
  }

}
