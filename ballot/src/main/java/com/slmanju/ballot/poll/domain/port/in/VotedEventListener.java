package com.slmanju.ballot.poll.domain.port.in;

import com.slmanju.ballot.poll.domain.event.VotedEvent;

public interface VotedEventListener {

  void onVote(VotedEvent votedEvent);

}
