package com.slmanju.ballot.poll.infrastructure.config;

import com.slmanju.ballot.poll.domain.port.in.PollService;
import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.poll.domain.api.PollServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PollConfiguration {

  @Bean
  public PollService pollService(PollRepository pollRepository) {
    return new PollServiceImpl(pollRepository);
  }

}
