package com.slmanju.ballot.voter.rest.mapper;

import com.slmanju.ballot.voter.domain.entity.Voter;
import com.slmanju.ballot.voter.rest.dto.VoterRequest;
import com.slmanju.ballot.voter.rest.dto.VoterView;
import org.springframework.stereotype.Component;

@Component
public class VoterMapper {

  public Voter toVoter(VoterRequest voterRequest) {
    return Voter.builder()
      .alias(voterRequest.getAlias())
      .email(voterRequest.getEmail())
      .build();
  }

  public VoterView toView(Voter voter) {
    return VoterView.builder()
      .id(voter.getId())
      .alias(voter.getAlias())
      .email(voter.getEmail())
      .build();
  }

}
