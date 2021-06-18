package com.slmanju.ballot.voteresult.domain.event;

import com.slmanju.ballot.vote.domain.event.VotedEvent;
import com.slmanju.ballot.voteresult.domain.port.in.VoteEventListener;
import com.slmanju.ballot.voteresult.domain.port.in.VoteResultService;
import com.slmanju.ballot.voteresult.domain.value.ResultVote;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VoteEventReceiver implements VoteEventListener {

  private final VoteResultService voteResultService;

  @Override
  public void receiveVote(VotedEvent votedEvent) {
    ResultVote vote = new ResultVote(votedEvent.getPoll(), votedEvent.getChoice(), votedEvent.getVoter());
    voteResultService.vote(vote);
  }

}
