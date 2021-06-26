package com.slmanju.ballot.voteresult.infrastructure.websocket;

import com.slmanju.ballot.voteresult.domain.entity.PollResult;
import com.slmanju.ballot.voteresult.domain.port.out.WebSocketService;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WebSocketApi implements WebSocketService {

  private final SimpMessagingTemplate simpMessagingTemplate;

  public void sendResult(PollResult voteResult) {
    System.out.println("sending...");
    simpMessagingTemplate.convertAndSend("/topic/" + voteResult.getPollId(), voteResult);
  }

}
