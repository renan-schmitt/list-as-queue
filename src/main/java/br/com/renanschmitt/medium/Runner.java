package br.com.renanschmitt.medium;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Runner {

  private static final int MESSAGES = 10;

  private final SimpleQueue queue;

  @SneakyThrows
  public void run() {

    final var consumer1 = new Consumer("Consumer 1", queue);
    final var consumer2 = new Consumer("Consumer 2", queue);

    final var producerThread1 = new Thread(new Producer("Producer 1", MESSAGES, queue));
    final var producerThread2 = new Thread(new Producer("Producer 2", MESSAGES, queue));
    final var producerThread3 = new Thread(new Producer("Producer 3", MESSAGES, queue));
    final var producerThread4 = new Thread(new Producer("Producer 4", MESSAGES, queue));
    final var consumerThread1 = new Thread(consumer1);
    final var consumerThread2 = new Thread(consumer2);

    producerThread1.start();
    producerThread2.start();
    producerThread3.start();
    producerThread4.start();

    consumerThread1.start();
    consumerThread2.start();

    producerThread1.join();
    producerThread2.join();
    producerThread3.join();
    producerThread4.join();
    consumer1.setRunning(false);
    consumer2.setRunning(false);
    consumerThread1.join();
    consumerThread2.join();
  }
}
