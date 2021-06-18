package com.slmanju.ballot.voter.infrastructure.adapter;

import com.slmanju.ballot.voter.domain.entity.Voter;
import com.slmanju.ballot.voter.domain.port.out.VoterRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VoterRepositoryAdapter implements VoterRepository {

  private Map<String, Voter> voters = new HashMap<>();

  @Override
  public void save(Voter voter) {
    voters.put(voter.getId(), voter);
  }

  @Override
  public Voter findById(String id) {
    return voters.get(id);
  }

}
