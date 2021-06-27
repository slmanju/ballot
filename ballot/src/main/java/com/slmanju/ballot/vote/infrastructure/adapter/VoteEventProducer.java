package com.slmanju.ballot.vote.infrastructure.adapter;

import com.slmanju.ballot.vote.domain.event.VotedEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VoteEventProducer {

  private static final Logger LOGGER = LoggerFactory.getLogger(VoteEventProducer.class);

  private JmsTemplate jmsTemplate;

  public void send(VotedEvent votedEvent) {
    jmsTemplate.convertAndSend(votedEvent);
    LOGGER.info("Sent message='{}'", votedEvent);
  }
}
