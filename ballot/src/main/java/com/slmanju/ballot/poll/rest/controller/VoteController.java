package com.slmanju.ballot.poll.rest.controller;

import com.slmanju.ballot.poll.domain.entity.Vote;
import com.slmanju.ballot.poll.domain.port.in.VoteService;
import com.slmanju.ballot.poll.rest.VoteApi;
import com.slmanju.ballot.poll.rest.dto.VoteRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class VoteController implements VoteApi {

  private final VoteService voteService;

  @Override
  public ResponseEntity<String> vote(VoteRequest voteRequest) {
    Vote vote = Vote.builder()
      .pollId(voteRequest.getPollId())
      .choice(voteRequest.getChoice())
      .voter(voteRequest.getVoter())
      .build();
    voteService.vote(vote);
    return ResponseEntity.ok("Voted");
  }

  @Override
  public ResponseEntity<List<Vote>> votes(String pollId) {
    List<Vote> votes = voteService.findVotesByPollId(pollId);
    return ResponseEntity.ok(votes);
  }

}
