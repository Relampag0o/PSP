import java.io.BufferedReader;
import java.io.FileReader;

public class Reader {

    public void read(String filename, String occurrence) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(filename));
            String line = "";
            int counter = 0;
            int counterLine = 0;
            while ((line = bfr.readLine()) != null) {
                String[] words = line.split(" ");
                for (String w : words) {
                    if (w.equalsIgnoreCase(occurrence))
                        counter++;
                }

            }
            System.out.println("The word " + occurrence + " appears :" + counter + " times" + " in the file: " + filename);
            bfr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Reader r = new Reader();
        r.read(args[0], args[1]);
    }
}
