package com.slmanju.ballot.poll.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Vote {

  private String id;
  private String pollId;
  private String choice;
  private String voter;

}
