package com.slmanju.ballot.poll.infrastructure.configuration;

import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.poll.domain.service.VoteServiceImpl;
import com.slmanju.ballot.poll.domain.port.in.VoteService;
import com.slmanju.ballot.poll.domain.port.out.EventPublisher;
import com.slmanju.ballot.poll.domain.port.out.VoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoteConfiguration {

  @Bean
  public VoteService voteService(VoteRepository voteRepository, PollRepository pollRepository, EventPublisher eventPublisher) {
    return new VoteServiceImpl(voteRepository, pollRepository, eventPublisher);
  }

}
