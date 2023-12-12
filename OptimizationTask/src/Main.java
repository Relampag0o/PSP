import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] files = {"rrhh (2).txt", "rrhh (1).txt", "gerencia (2).txt", "contabilidad (2).txt", "comercio (2).txt", "informatica (2).txt"};

        LinkedList<Reader> readers = new LinkedList<Reader>();
        LinkedList<Thread> threads = new LinkedList<Thread>();
        int threadNumbers = 3;
        int operation = files.length / threadNumbers;
        int counter = 0;
        int stacker = 0;

        for (int i = 0; i < threadNumbers; i++) {
            String[] filesToRead = new String[operation];
            for (int j = i * operation; j < (i + 1) * operation; j++) {
                filesToRead[counter] = files[j];
                counter++;
            }
            Reader reader = new Reader(filesToRead);
            Thread thread = new Thread(reader);
            readers.add(reader);
            thread.start();
            threads.add(thread);
            counter = 0;


        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (Reader reader : readers) {
            stacker += reader.getCounter();
        }

        System.out.println(stacker);
    }

}