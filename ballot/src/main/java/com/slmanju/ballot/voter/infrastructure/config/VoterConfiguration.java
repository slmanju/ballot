package com.slmanju.ballot.voter.infrastructure.config;

import com.slmanju.ballot.voter.domain.port.in.VoterService;
import com.slmanju.ballot.voter.domain.port.out.VoterRepository;
import com.slmanju.ballot.voter.domain.api.VoterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoterConfiguration {

  @Bean
  public VoterService voterService(VoterRepository voterRepository) {
    return new VoterServiceImpl(voterRepository);
  }

}
