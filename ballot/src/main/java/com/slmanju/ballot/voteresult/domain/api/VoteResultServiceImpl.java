package com.slmanju.ballot.voteresult.domain.api;

import com.slmanju.ballot.poll.domain.entity.Poll;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.voteresult.domain.entity.PollResult;
import com.slmanju.ballot.voteresult.domain.port.in.VoteResultService;
import com.slmanju.ballot.voteresult.domain.port.out.VoteResultRepository;
import com.slmanju.ballot.voteresult.domain.value.ChoiceResult;
import com.slmanju.ballot.voteresult.domain.value.ResultVote;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class VoteResultServiceImpl implements VoteResultService {

  private final VoteResultRepository voteResultRepository;
  private final PollRepository pollRepository;

  @Override
  public void vote(ResultVote vote) {
    voteResultRepository.saveVote(vote);
  }

  @Override
  public PollResult findVoteResult(String pollId) {
    List<ResultVote> votes = voteResultRepository.findAllById(pollId);
    Poll poll = pollRepository.findById(pollId);

    PollResult pollResult = PollResult.emptyResult(poll);

    for (ResultVote vote : votes) {
      String choice = vote.getChoice();
      List<ChoiceResult> choiceResults = pollResult.getChoiceResults();
      for (ChoiceResult choiceResult : choiceResults) {
        if (choiceResult.getChoice().equals(choice)) {
          choiceResult.setVotes(choiceResult.getVotes() + 1);
        }
      }
    }

    return pollResult;
  }

}
