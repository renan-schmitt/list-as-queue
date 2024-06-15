package br.com.renanschmitt.medium;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Consumer implements Runnable {

  private final String id;
  private final SimpleQueue queue;
  @Setter private boolean running = true;

  @Override
  public void run() {
    while (running) {
      try {
        sleep();
        final var msg = queue.pop();
        System.out.println(
            id + ": Message \"" + msg + "\" removed from queue (size: " + queue.size() + ")");
      } catch (final Exception e) {
        System.out.println(id + ": Error on consumer");
        e.printStackTrace();
      }
    }
  }

  @SneakyThrows
  private void sleep() {
    Thread.sleep(50 + (int) (Math.random() * 50));
  }
}
