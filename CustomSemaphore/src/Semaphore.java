public class Semaphore {
    private int maxThreads;
    private int currentThreads = 0;

    public Semaphore(int threads) {
        this.maxThreads = threads;
        this.currentThreads = 0;

    }

    public void acquire() {

        while (currentThreads == maxThreads) {
            try {
                System.out.println("Waiting");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

        currentThreads++;
        System.out.println("Acquired");

    }

    public void release() {
        notifyAll();
        System.out.println("Released");
        currentThreads--;

    }
}
