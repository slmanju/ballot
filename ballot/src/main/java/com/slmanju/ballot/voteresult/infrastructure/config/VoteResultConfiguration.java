package com.slmanju.ballot.voteresult.infrastructure.config;

import com.slmanju.ballot.poll.domain.port.out.PollRepository;
import com.slmanju.ballot.voteresult.domain.api.VoteResultServiceImpl;
import com.slmanju.ballot.voteresult.domain.api.WebsocketService;
import com.slmanju.ballot.voteresult.domain.event.VoteEventReceiver;
import com.slmanju.ballot.voteresult.domain.port.in.VoteEventListener;
import com.slmanju.ballot.voteresult.domain.port.in.VoteResultService;
import com.slmanju.ballot.voteresult.domain.port.out.VoteResultRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Configuration
public class VoteResultConfiguration {

  @Bean
  public WebsocketService websocketService(SimpMessagingTemplate simpMessagingTemplate) {
    return new WebsocketService(simpMessagingTemplate);
  }

  @Bean
  public VoteResultService voteResultService(VoteResultRepository voteResultRepository,
                                             PollRepository pollRepository,
                                             WebsocketService websocketService) {
    return new VoteResultServiceImpl(voteResultRepository, pollRepository, websocketService);
  }

  @Bean
  public VoteEventListener voteEventListener(VoteResultService voteResultService) {
    return new VoteEventReceiver(voteResultService);
  }

}
