package com.slmanju.ballot.voteresult.rest;

import com.slmanju.ballot.voteresult.domain.entity.PollResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface VoteResultApi {

  @GetMapping(value = "/poll-results/{pollId}")
  ResponseEntity<PollResult> results(@PathVariable("pollId") String pollId);

}
