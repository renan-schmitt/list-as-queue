package br.com.renanschmitt.medium;

import java.util.LinkedList;
import java.util.List;
import lombok.SneakyThrows;

public class Queue3 implements SimpleQueue {

  private final List<String> queue = new LinkedList<>();

  @Override
  public void push(final String id) {
    synchronized (queue) {
      queue.add(id);
      queue.notifyAll();
    }
  }

  @SneakyThrows
  @Override
  public String pop() {
    synchronized (queue) {
      while (size() == 0) {
        queue.wait();
      }

      return queue.remove(0);
    }
  }

  @Override
  public int size() {
    return queue.size();
  }
}
