package br.com.renanschmitt.medium;

import java.util.LinkedList;
import java.util.List;

public class Queue1 implements SimpleQueue {

  private List<String> queue = new LinkedList<>();

  @Override
  public void push(final String id) {
    queue.add(id);
  }

  @Override
  public String pop() {
    return queue.remove(0);
  }

  @Override
  public int size() {
    return queue.size();
  }
}
