import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        String[] dirs = {"/home/jose/Escritorio/testdelete", "/home/jose/Escritorio/testdelete2", "/home/jose/Escritorio/testdelete3"};

        for (int i = 0; i < dirs.length; i++) {
            ProcessBuilder pb = new ProcessBuilder("java", "Finder", dirs[i], "oddnumbers.txt");
            Process p = pb.start();
            try {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
                System.out.println("I am the process: " + p.pid() + " and i found the word " + bfr.readLine() + " times");

                bfr.close();
            } catch (Exception e) {
                e.printStackTrace();

            } finally {

            }

        }


    }
}
