package com.slmanju.ballot.poll.rest.controller;

import com.slmanju.ballot.poll.domain.entity.PollResult;
import com.slmanju.ballot.poll.domain.port.in.PollResultService;
import com.slmanju.ballot.poll.rest.PollResultApi;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PollResultController implements PollResultApi {

  private final PollResultService pollResultService;

  @Override
  public ResponseEntity<PollResult> results(String pollId) {
    PollResult pollResult = pollResultService.findPollResult(pollId);
    return ResponseEntity.ok(pollResult);
  }

}
