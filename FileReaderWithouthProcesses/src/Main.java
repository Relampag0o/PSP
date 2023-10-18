import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        for (String arg : args) {

            BufferedReader bfr = new BufferedReader(new FileReader(arg));
            try {



            } catch (Exception e) {
                System.out.println("There was an error...");
            }
        }
    }
}