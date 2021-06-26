package com.slmanju.ballot.voteresult.infrastructure.adapter;

import com.slmanju.ballot.voteresult.domain.value.ResultVote;
import lombok.AllArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@Component
public class VoteResultCacheManager {

  private CacheManager cacheManager;

  public void put(ResultVote vote) {
    Cache cache = cacheManager.getCache(vote.getPollId());
    assert cache != null;
    cache.put(vote.getVoter(), vote);
  }

  public List<ResultVote> find(String pollId) {
    Cache cache = cacheManager.getCache(pollId);
    com.github.benmanes.caffeine.cache.Cache<Object, Object> nativeCache = (com.github.benmanes.caffeine.cache.Cache<Object, Object>) cache.getNativeCache();

    Collection<Object> values = nativeCache.asMap().values();
    return values.stream().map(value -> (ResultVote) value).collect(toList());
  }
}
