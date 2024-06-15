package br.com.renanschmitt.medium;

import java.util.concurrent.LinkedBlockingQueue;
import lombok.SneakyThrows;

public class Queue4 implements SimpleQueue {

  private final LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

  @SneakyThrows
  @Override
  public void push(final String id) {
    queue.put(id);
  }

  @SneakyThrows
  @Override
  public String pop() {
    return queue.take();
  }

  @Override
  public int size() {
    return queue.size();
  }
}
