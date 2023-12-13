import java.util.LinkedList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public int[] createArray(int size) {
        Random r = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(9);

        }
        return array;
    }

    public void showArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {


        LinkedList<Thread> threads = new LinkedList<Thread>();
        LinkedList<Adittion> adittions = new LinkedList<Adittion>();
        LinkedList<FindPattern> findPatterns = new LinkedList<FindPattern>();

        Main m = new Main();
        int threadsNumber = Integer.parseInt(args[0]);
        int numberOfElements = Integer.parseInt(args[1]);
        int pattern = Integer.parseInt(args[2]);
        int operation = numberOfElements / threadsNumber;
        int[] array = m.createArray(numberOfElements);
        int counter = 0;
        int stacker = 0;

        m.showArray(array);
/*
        // EXERCISE 1
        for (int i = 0; i < threadsNumber; i++) {
            int[] numbers = new int[operation];
            for (int j = i * operation; j < (i + 1) * operation; j++) {
                //filesToRead[counter] = files[j];
                numbers[counter] = array[j];
                counter++;
            }
            Adittion adittion = new Adittion(numbers);
            Thread t = new Thread(adittion);
            t.start();
            threads.add(t);
            adittions.add(adittion);


            counter = 0;
        }

        for (Adittion adittion : adittions) {
            stacker += adittion.getCounter();

        }
        System.out.println("Addition: " + stacker);

*/
        // EXERCISE 2:
        for (int i = 0; i < threadsNumber; i++) {
            int[] numbers = new int[operation];
            for (int j = i * operation; j < (i + 1) * operation; j++) {

                numbers[counter] = array[j];
                counter++;
            }
            FindPattern find = new FindPattern(numbers, pattern);
            Thread t = new Thread(find);
            t.start();
            threads.add(t);
            findPatterns.add(find);


            counter = 0;
        }

        for (FindPattern patterns : findPatterns) {
            if (patterns.getFound() ) {
                System.out.println("The pattern " + pattern + " was found!");

            }

        }

        // EXERCISE 3:






    }
}