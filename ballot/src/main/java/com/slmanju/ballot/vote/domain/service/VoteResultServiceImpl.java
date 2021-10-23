package com.slmanju.ballot.vote.domain.service;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.vote.domain.entity.PollResult;
import com.slmanju.ballot.vote.domain.port.in.VoteResultService;
import com.slmanju.ballot.vote.domain.port.out.VoteResultRepository;
import com.slmanju.ballot.vote.domain.port.out.WebSocketService;
import com.slmanju.ballot.vote.domain.value.ChoiceResult;
import com.slmanju.ballot.vote.domain.value.Vote;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VoteResultServiceImpl implements VoteResultService {

  private final VoteResultRepository voteResultRepository;
  private final PollRepository pollRepository;
  private final WebSocketService websocketService;

  @Override
  public void vote(Vote vote) {
    voteResultRepository.saveVote(vote);

    PollResult voteResult = findVoteResult(vote.getPollId());
    websocketService.sendResult(voteResult);
  }

  @Override
  public PollResult findVoteResult(String pollId) {
    List<Vote> votes = voteResultRepository.findAllById(pollId);
    Poll poll = pollRepository.findById(pollId);

    PollResult pollResult = PollResult.emptyResult(poll);

    for (Vote vote : votes) {
      List<ChoiceResult> choiceResults = pollResult.getChoiceResults();
      for (ChoiceResult choiceResult : choiceResults) {
        if (choiceResult.getChoice().equals(vote.getChoice())) {
          choiceResult.increment();
        }
      }
    }
    return pollResult;
  }

}
