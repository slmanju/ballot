package com.slmanju.ballot.poll.rest;

import com.slmanju.ballot.poll.rest.dto.PollRequest;
import com.slmanju.ballot.poll.rest.dto.PollView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PollApi {

  @PostMapping(value = "/polls")
  ResponseEntity<String> createPoll(@RequestBody PollRequest pollRequest);

  @GetMapping(value = "/polls/{id}")
  ResponseEntity<PollView> getPoll(@PathVariable("id") String id);

}
