package com.slmanju.ballot.poll.rest;

import com.slmanju.ballot.poll.domain.entity.Vote;
import com.slmanju.ballot.poll.rest.dto.VoteRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface VoteApi {

  @PostMapping(value = "/votes")
  ResponseEntity<String> vote(@RequestBody VoteRequest voteRequest);

  @GetMapping(value = "/votes/{pollId}")
  ResponseEntity<List<Vote>> votes(@PathVariable("pollId") String pollId);

}
