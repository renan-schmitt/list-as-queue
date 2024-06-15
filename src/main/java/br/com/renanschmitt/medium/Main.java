package br.com.renanschmitt.medium;

public class Main {
  public static void main(final String[] args) {
    switch (Integer.parseInt(args[0])) {
      case 1 -> new Runner(new Queue1()).run();
      case 2 -> new Runner(new Queue2()).run();
      case 3 -> new Runner(new Queue3()).run();
      case 4 -> new Runner(new Queue4()).run();
    }
  }
}
