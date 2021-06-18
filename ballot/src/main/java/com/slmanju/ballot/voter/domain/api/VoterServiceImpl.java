package com.slmanju.ballot.voter.domain.api;

import com.slmanju.ballot.voter.domain.entity.Voter;
import com.slmanju.ballot.voter.domain.port.in.VoterService;
import com.slmanju.ballot.voter.domain.port.out.VoterRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class VoterServiceImpl implements VoterService {

  private VoterRepository voterRepository;

  @Override
  public String save(Voter voter) {
    voter.setId(UUID.randomUUID().toString());
    voterRepository.save(voter);
    return voter.getId();
  }

  @Override
  public Voter findById(String id) {
    return voterRepository.findById(id);
  }

}
