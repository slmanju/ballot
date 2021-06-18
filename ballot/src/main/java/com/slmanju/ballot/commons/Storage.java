package com.slmanju.ballot.commons;

import java.util.HashMap;
import java.util.Map;

public class Storage<I, T> {

  private Map<I, T> values = new HashMap<>();

  public void save(I key, T t) {
    values.put(key, t);
  }

  public T get(I key) {
    return values.get(key);
  }

}
