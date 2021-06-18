package com.slmanju.ballot.voter.domain.port.out;

import com.slmanju.ballot.voter.domain.entity.Voter;

public interface VoterRepository
{

  void save(Voter voter);

  Voter findById(String id);

}
