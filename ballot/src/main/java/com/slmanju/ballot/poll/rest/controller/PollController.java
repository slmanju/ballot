package com.slmanju.ballot.poll.rest.controller;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.in.PollService;
import com.slmanju.ballot.poll.rest.PollApi;
import com.slmanju.ballot.poll.rest.dto.PollRequest;
import com.slmanju.ballot.poll.rest.dto.PollView;
import com.slmanju.ballot.poll.rest.mapper.PollMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class PollController implements PollApi {

  private final PollService pollService;
  private final PollMapper pollMapper;

  @Override
  public ResponseEntity<String> createPoll(PollRequest pollRequest) {
    String pollId = pollService.createPoll(pollMapper.toCreatePoll(pollRequest));
    return ResponseEntity.ok(pollId);
  }

  @Override
  public ResponseEntity<PollView> getPoll(String id) {
    Poll poll = pollService.findById(id);
    PollView pollView = pollMapper.fromPoll(poll);
    return ResponseEntity.ok(pollView);
  }

}
