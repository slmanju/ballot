package com.slmanju.ballot.poll.infrastructure.configuration;

import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.poll.domain.service.PollResultServiceImpl;
import com.slmanju.ballot.poll.domain.port.in.PollResultService;
import com.slmanju.ballot.poll.domain.port.out.PollResultRepository;
import com.slmanju.ballot.poll.domain.port.out.PollResultPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoteResultConfiguration {

  @Bean
  public PollResultService voteResultService(PollResultRepository pollResultRepository,
                                             PollRepository pollRepository,
                                             PollResultPublisher websocketService) {
    return new PollResultServiceImpl(pollResultRepository, pollRepository, websocketService);
  }

}
