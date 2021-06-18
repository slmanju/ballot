package com.slmanju.ballot.poll.domain.port.in;

import com.slmanju.ballot.poll.domain.entity.Poll;

public interface PollService {

  String createPoll(Poll poll);

  Poll findById(String id);

}
