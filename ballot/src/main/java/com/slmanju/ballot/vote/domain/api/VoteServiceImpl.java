package com.slmanju.ballot.vote.domain.api;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.vote.domain.entity.Vote;
import com.slmanju.ballot.vote.domain.event.VotedEvent;
import com.slmanju.ballot.vote.domain.port.in.VoteService;
import com.slmanju.ballot.vote.domain.port.out.EventPublisher;
import com.slmanju.ballot.vote.domain.port.out.VoteRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class VoteServiceImpl implements VoteService {

  private final VoteRepository voteRepository;
  private final PollRepository pollRepository;
  private final EventPublisher eventPublisher;

  @Override
  public void vote(Vote vote) {
    Poll poll = pollRepository.findById(vote.getPollId()); // validate Poll and Choice(s)

    vote.setId(UUID.randomUUID().toString());
    voteRepository.save(vote); // should I save Poll with Vote ? in a document store.

    eventPublisher.publishVoted(new VotedEvent(vote.getPollId(), vote.getVoter(), vote.getChoice()));
  }

  @Override
  public List<Vote> findVotesByPollId(String pollId) {
    return voteRepository.findByPollId(pollId);
  }

}
