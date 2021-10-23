package com.slmanju.ballot.poll.infrastructure.adapter.repository;

import com.slmanju.ballot.poll.domain.port.out.PollResultRepository;
import com.slmanju.ballot.poll.domain.value.Vote;
import com.slmanju.ballot.poll.infrastructure.adapter.PollVoteCacheManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class PollResultAdapter implements PollResultRepository {

  private final PollVoteCacheManager pollVoteCacheManager;

  @Override
  public void saveVote(Vote vote) {
    pollVoteCacheManager.put(vote);
    // TODO save in database as well
  }

  @Override
  public List<Vote> findVotesByPollId(String pollId) {
    return pollVoteCacheManager.find(pollId);
  }

}
