import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Semaphore table = new Semaphore(4);
        Semaphore[] forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {

            forks[i] = new Semaphore(1);

        }


        for (int i = 0; i < 5; i++) {

            Philosopher p = new Philosopher("Philosopher " + i, i, table, forks[i], forks[(i + 1) % 5]);
            Thread t = new Thread(p);
            t.start();


        }
    }
}