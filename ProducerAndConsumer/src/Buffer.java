import java.util.Random;

public class Buffer {

    private int actualAmount;
    private int maxAmount;


    public Buffer(int actualAmount, int maxAmount) {
        this.actualAmount = actualAmount;
        this.maxAmount = maxAmount;
    }

    public int getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(int actualAmount) {
        this.actualAmount = actualAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public String toString() {
        return "Buffer{" +
                "actualAmount=" + actualAmount +
                ", maxAmount=" + maxAmount +
                '}';
    }


    public synchronized void consume(String name) {
        while (this.actualAmount <= 0) {
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        System.out.println("Consumer: " + name + " consuming..");
        try {
            this.actualAmount--;
            Random r = new Random();
            Thread.sleep(r.nextInt(600));

        } catch (Exception e) {
            e.printStackTrace();

        }

        System.out.println("Im the consumer " + name + " and i am quitting after consuming." + this.actualAmount + "/" + this.maxAmount);
        notifyAll();
    }

    public synchronized void produce(String name) {
        while (this.actualAmount == this.maxAmount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            this.actualAmount++;
            Random r = new Random();
            Thread.sleep(r.nextInt(600));

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Im the producer " + name + " and i produced an unit!: " + this.actualAmount + "/" + this.maxAmount);
        notifyAll();


    }
}
