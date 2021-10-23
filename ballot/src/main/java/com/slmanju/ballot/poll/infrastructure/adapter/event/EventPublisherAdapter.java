package com.slmanju.ballot.poll.infrastructure.adapter.event;

import com.slmanju.ballot.poll.domain.event.VotedEvent;
import com.slmanju.ballot.poll.domain.port.out.EventPublisher;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EventPublisherAdapter implements EventPublisher {

  private static final Logger LOGGER = LoggerFactory.getLogger(EventPublisherAdapter.class);

  private final JmsTemplate jmsTemplate;

  @Override
  public void publishVotedEvent(VotedEvent votedEvent) {
    jmsTemplate.convertAndSend(votedEvent);
    LOGGER.info("Sent message='{}'", votedEvent);
  }

}
