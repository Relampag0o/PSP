import java.io.*;
import java.net.URL;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
            String line;

            while ((line = bfr.readLine()) != null) {
                new Thread(new Reader(line)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
