package com.slmanju.ballot.poll.domain.service;

import com.slmanju.ballot.poll.domain.entity.Vote;
import com.slmanju.ballot.poll.domain.event.VotedEvent;
import com.slmanju.ballot.poll.domain.port.in.VoteService;
import com.slmanju.ballot.poll.domain.port.out.EventPublisher;
import com.slmanju.ballot.poll.domain.port.out.VoteRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

  private final VoteRepository voteRepository;
  private final EventPublisher eventPublisher;

  @Override
  public void vote(Vote vote) {
    vote.setId(UUID.randomUUID().toString());
    voteRepository.save(vote);

    eventPublisher.publishVotedEvent(new VotedEvent(vote.getPollId(), vote.getVoter(), vote.getChoice()));
  }

  // TODO why do I need this?
  @Override
  public List<Vote> findVotesByPollId(String pollId) {
    return voteRepository.findByPollId(pollId);
  }

}
