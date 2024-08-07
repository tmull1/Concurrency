package org.example;

class Consumer implements Runnable {
    private final SharedBuffer sharedBuffer;

    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }

    @Override
    public void run() {
        int sum = 0;
        while (true) {
            try {
                int number = sharedBuffer.remove();
                sum += number;
                System.out.println("Consumed: " + number + ", Current Sum: " + sum);
                Thread.sleep(500); // Simulate some delay in consumption
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

