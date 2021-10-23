package com.slmanju.ballot.vote.rest.controller;

import com.slmanju.ballot.vote.domain.entity.PollResult;
import com.slmanju.ballot.vote.domain.port.in.VoteResultService;
import com.slmanju.ballot.vote.rest.VoteResultApi;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class VoteResultController implements VoteResultApi {

  private final VoteResultService voteResultService;

  @Override
  public ResponseEntity<PollResult> results(String pollId) {
    PollResult voteResult = voteResultService.findVoteResult(pollId);
    return ResponseEntity.ok(voteResult);
  }

}
