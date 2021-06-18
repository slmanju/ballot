package com.slmanju.ballot.voter.rest.controller;

import com.slmanju.ballot.voter.domain.entity.Voter;
import com.slmanju.ballot.voter.domain.port.in.VoterService;
import com.slmanju.ballot.voter.rest.VoterApi;
import com.slmanju.ballot.voter.rest.dto.VoterRequest;
import com.slmanju.ballot.voter.rest.dto.VoterView;
import com.slmanju.ballot.voter.rest.mapper.VoterMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class VoterController implements VoterApi {

  private final VoterService voterService;
  private final VoterMapper voterMapper;

  @Override
  public ResponseEntity<String> save(VoterRequest voterRequest) {
    String id = voterService.save(voterMapper.toVoter(voterRequest));
    return ResponseEntity.ok(id);
  }

  @Override
  public ResponseEntity<VoterView> getPoll(String id) {
    Voter voter = voterService.findById(id);
    VoterView voterView = voterMapper.toView(voter);
    return ResponseEntity.ok(voterView);
  }

}
