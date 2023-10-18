import java.io.*;
import java.util.LinkedList;

public class Launcher {
    public static void main(String[] args) {
        int counter = 0;
        long startTime = System.nanoTime();
        LinkedList<Process> processes = new LinkedList<Process>();

        for (String arg : args) {
            ProcessBuilder pb = new ProcessBuilder("java", "MyProcess", arg);
            try {

                processes.add(pb.start());
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (Process p : processes) {
                try {
                    int exitcode = p.waitFor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (Process p : processes) {
                try {
                    File f = new File(arg);

                    BufferedReader bfr = new BufferedReader(new FileReader("C:\\Users\\Jose\\Downloads\\" + "sumado" + f.getName()));

                    //System.out.println(bfr.readLine());
                    int fileAmount = Integer.parseInt(bfr.readLine());
                    counter += fileAmount;
                    System.out.println("File name: " + f.getName() + " amount: " + fileAmount);

                    bfr.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            long endTime = System.nanoTime();
            System.out.println("Total amount: " + counter);
            System.out.println("Total time: " + (endTime - startTime) / 1e6 + " ms");
        }
    }
}