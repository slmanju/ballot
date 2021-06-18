package com.slmanju.ballot.vote.domain.port.out;

import com.slmanju.ballot.vote.domain.entity.Vote;

public interface VoteListener {

  void voteCreated(Vote vote);

}
