package com.slmanju.ballot.poll.domain.port.out;

import com.slmanju.ballot.poll.domain.entity.Poll;

public interface PollRepository {

  void save(Poll poll);

  Poll findById(String id);

}
