package com.slmanju.ballot.poll.domain.service;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.poll.domain.entity.PollResult;
import com.slmanju.ballot.poll.domain.port.in.PollResultService;
import com.slmanju.ballot.poll.domain.port.out.PollResultRepository;
import com.slmanju.ballot.poll.domain.port.out.PollResultPublisher;
import com.slmanju.ballot.poll.domain.value.ChoiceResult;
import com.slmanju.ballot.poll.domain.value.Vote;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PollResultServiceImpl implements PollResultService {

  private final PollResultRepository pollResultRepository;
  private final PollRepository pollRepository;
  private final PollResultPublisher pollResultPublisher;

  @Override
  public void onVoteReceived(Vote vote) { // TODO what name is better? suitable for a separate class?
    pollResultRepository.saveVote(vote);
    PollResult voteResult = findPollResult(vote.getPollId());
    pollResultPublisher.publishResult(voteResult);
  }

  // TODO if poll completed, fetch from saved, else calculate
  @Override
  public PollResult findPollResult(String pollId) {
    Poll poll = pollRepository.findById(pollId);
    List<Vote> votes = pollResultRepository.findVotesByPollId(pollId);

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
