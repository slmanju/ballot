package com.slmanju.ballot.poll.rest;

import com.slmanju.ballot.poll.domain.entity.PollResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface PollResultApi {

  @GetMapping(value = "/poll-results/{pollId}")
  ResponseEntity<PollResult> results(@PathVariable("pollId") String pollId);

}
