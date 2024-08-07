package org.example;

import java.util.Random;

class Producer implements Runnable {
    private final SharedBuffer sharedBuffer;
    private final Random random = new Random();

    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int number = random.nextInt(100); // Generate a random number between 0 and 99
                sharedBuffer.add(number);
                System.out.println("Produced: " + number);
                Thread.sleep(500); // Simulate some delay in production
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

