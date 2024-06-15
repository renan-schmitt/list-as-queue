package br.com.renanschmitt.medium;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Producer implements Runnable {

  private final String id;
  private final int numberOfMessages;
  private final SimpleQueue queue;

  @Override
  public void run() {

    for (int i = 0; i < numberOfMessages; i++) {
      queue.push(id + ": messageId " + i);
      System.out.println(id + ": Message " + i + " added to queue (size: " + queue.size() + ")");
      sleep();
    }
  }

  @SneakyThrows
  private void sleep() {
    Thread.sleep(400 + (int) (Math.random() * 100));
  }
}
