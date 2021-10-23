package com.slmanju.ballot.poll.infrastructure.adapter.event;

import com.slmanju.ballot.poll.domain.entity.PollResult;
import com.slmanju.ballot.poll.domain.port.out.PollResultPublisher;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WebSocketResultPublisher implements PollResultPublisher {

  private final SimpMessagingTemplate simpMessagingTemplate;

  public void publishResult(PollResult pollResult) {
    System.out.println("sending...");
    simpMessagingTemplate.convertAndSend("/topic/" + pollResult.getPollId(), pollResult);
  }

}
