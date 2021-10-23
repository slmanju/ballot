package com.slmanju.ballot.poll.infrastructure.adapter.repository;

import com.slmanju.ballot.poll.domain.entity.Vote;
import com.slmanju.ballot.poll.domain.port.out.VoteRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class VoteRepositoryAdapter implements VoteRepository {

  private Map<String, Map<String, Vote>> pollVotes = new HashMap<>();

  @Override
  public void save(Vote vote) {
    Map<String, Vote> votes = this.pollVotes.get(vote.getPollId());
    if (Objects.isNull(votes)) {
      votes = new HashMap<>();
      pollVotes.put(vote.getPollId(), votes);
    }
    if (!votes.containsKey(vote.getVoter())) {
      votes.put(vote.getVoter(), vote);
    }
  }

  @Override
  public List<Vote> findByPollId(String pollId) {
    Map<String, Vote> votes = pollVotes.get(pollId);
    if (Objects.nonNull(votes)) {
      return new ArrayList<>(votes.values());
    }
    return Collections.emptyList();
  }

}
