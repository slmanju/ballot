package com.slmanju.ballot.poll.domain.port.out;

import com.slmanju.ballot.poll.domain.value.Vote;

import java.util.List;

public interface PollResultRepository {

  void saveVote(Vote vote);

  List<Vote> findVotesByPollId(String pollId);

}
