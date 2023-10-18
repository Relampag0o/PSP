import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Launcher {
    public static void main(String[] args) {
        int counter = 0;
        long startTime = System.nanoTime();

        for (String arg : args) {
            ProcessBuilder pb = new ProcessBuilder("java", "MyProcess", arg);
            try {
                File f = new File(arg);
                Process process = pb.start();
                int exitcode = process.waitFor();
                BufferedReader bfr = new BufferedReader(new InputStreamReader(process.getInputStream()));
                int fileAmount = Integer.parseInt(bfr.readLine());
                counter += fileAmount;
                System.out.println("File name: " + f.getName() + " amount: " + fileAmount);

                bfr.close();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
        long endTime = System.nanoTime();
        System.out.println("Total amount: " + counter);
        System.out.println("Total time: " + (endTime - startTime) / 1e6 + " ms");
    }
}