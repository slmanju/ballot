package com.slmanju.ballot.poll.infrastructure.adapter;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PollRepositoryAdapter implements PollRepository {

  private List<Poll> polls = new ArrayList<>();

  @Override
  public void save(Poll poll) {
    polls.add(poll);
  }

  @Override
  public Poll findById(String id) {
    return polls.stream()
      .filter(poll -> poll.getId().equals(id))
      .findFirst()
      .orElse(null);
  }

}
