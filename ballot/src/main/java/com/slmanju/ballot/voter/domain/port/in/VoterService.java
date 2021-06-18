package com.slmanju.ballot.voter.domain.port.in;

import com.slmanju.ballot.voter.domain.entity.Voter;

public interface VoterService
{

  String save(Voter voter);

  Voter findById(String id);

}
