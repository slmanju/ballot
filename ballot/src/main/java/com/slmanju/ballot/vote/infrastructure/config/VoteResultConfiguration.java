package com.slmanju.ballot.vote.infrastructure.config;

import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.vote.domain.service.VoteResultServiceImpl;
import com.slmanju.ballot.vote.domain.port.in.VoteResultService;
import com.slmanju.ballot.vote.domain.port.out.VoteResultRepository;
import com.slmanju.ballot.vote.domain.port.out.WebSocketService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoteResultConfiguration {

  @Bean
  public VoteResultService voteResultService(VoteResultRepository voteResultRepository,
                                             PollRepository pollRepository,
                                             WebSocketService websocketService) {
    return new VoteResultServiceImpl(voteResultRepository, pollRepository, websocketService);
  }

}
