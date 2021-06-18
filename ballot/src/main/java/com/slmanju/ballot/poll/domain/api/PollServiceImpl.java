package com.slmanju.ballot.poll.domain.api;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.in.PollService;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class PollServiceImpl implements PollService {

  private final PollRepository pollRepository;

  @Override
  public String createPoll(Poll poll) {
    poll.setId(UUID.randomUUID().toString());
    pollRepository.save(poll);
    return poll.getId();
  }

  @Override
  public Poll findById(String id) {
    return pollRepository.findById(id);
  }

}
