package com.slmanju.ballot.vote.infrastructure.config;

import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.vote.domain.api.VoteServiceImpl;
import com.slmanju.ballot.vote.domain.port.in.VoteService;
import com.slmanju.ballot.vote.domain.port.out.EventPublisher;
import com.slmanju.ballot.vote.domain.port.out.VoteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoteConfiguration {

  @Bean
  public VoteService voteService(VoteRepository voteRepository, PollRepository pollRepository, EventPublisher eventPublisher) {
    return new VoteServiceImpl(voteRepository, pollRepository, eventPublisher);
  }

}
