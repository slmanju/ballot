package com.slmanju.ballot.vote.domain.port.in;

import com.slmanju.ballot.vote.domain.event.VotedEvent;

public interface VoteEventListener {

  void onVote(VotedEvent votedEvent);

}
