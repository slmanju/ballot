package com.slmanju.ballot.voteresult.domain.api;

import com.slmanju.ballot.voteresult.domain.entity.PollResult;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@AllArgsConstructor
public class WebsocketService {

  private final SimpMessagingTemplate simpMessagingTemplate;

  public void sendResult(PollResult voteResult) {
    System.out.println("sending...");
    simpMessagingTemplate.convertAndSend("/topic/" + voteResult.getPollId(), voteResult);
  }

}
