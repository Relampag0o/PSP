import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable {

    private String name;
    private int id;
    private Semaphore table;

    private Semaphore leftFork;
    private Semaphore rightFork;


    public Philosopher(String name, int id, Semaphore table, Semaphore leftFork, Semaphore rightFork) {
        this.name = name;
        this.table = table;
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Semaphore getLeftFork() {
        return leftFork;
    }

    public void setLeftFork(Semaphore leftFork) {
        this.leftFork = leftFork;
    }

    public Semaphore getRightFork() {
        return rightFork;
    }

    public void setRightFork(Semaphore rightFork) {
        this.rightFork = rightFork;
    }

    @Override
    public void run() {

        while (true) {
            try {
                //Thread.sleep(3000);
                table.acquire();
                leftFork.acquire();
                rightFork.acquire();
                System.out.println("Philosopher " + id + " is eating with forks " + id + " and " + (id + 1) % 5);
                Thread.sleep(3000);
                System.out.println("Philosopher " + id + " has finished eating");
                leftFork.release();
                rightFork.release();
                table.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
