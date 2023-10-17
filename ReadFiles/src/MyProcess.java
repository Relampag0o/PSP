import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class MyProcess {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int counter = 0;
                BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
                String line = "";
                while ((line = bfr.readLine()) != null) {
                    counter += Integer.parseInt(line);
                }
                System.out.println(counter);
                bfr.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

