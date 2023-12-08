import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int counter = 0;
        LinkedList<Reader> readers = new LinkedList<Reader>();
        LinkedList<Thread> threads = new LinkedList<Thread>();

        for (String file : args) {
            Reader reader = new Reader(file);
            Thread thread = new Thread(reader);
            thread.start();
            readers.add(reader);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (Reader reader : readers) {
            counter += reader.getCounter();
        }

        System.out.println("Counter: " + counter);


    }

}