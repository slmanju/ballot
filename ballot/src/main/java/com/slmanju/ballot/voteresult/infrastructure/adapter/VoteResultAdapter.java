package com.slmanju.ballot.voteresult.infrastructure.adapter;

import com.slmanju.ballot.voteresult.domain.port.out.VoteResultRepository;
import com.slmanju.ballot.voteresult.domain.value.ResultVote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
public class VoteResultAdapter implements VoteResultRepository {

  private ConcurrentMap<String, List<ResultVote>> votes = new ConcurrentHashMap<>();

  @Override
  public void saveVote(ResultVote vote) {
    votes.computeIfAbsent(vote.getPollId(), key -> new ArrayList<>()).add(vote);
  }

  @Override
  public List<ResultVote> findAllById(String pollId) {
    return votes.getOrDefault(pollId, new ArrayList<>());
  }

}
