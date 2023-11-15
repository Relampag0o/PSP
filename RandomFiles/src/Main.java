import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;

public class Main {

    public LinkedList<Process> processes;

    public Main() {
        this.processes = new LinkedList<Process>();
    }


    public void launch() {
        ProcessBuilder pb = new ProcessBuilder("java", "Writer");
        try {
            for (int i = 0; i < 4; i++) {
                processes.add(pb.start());
            }

            for (Process p : processes) {
                p.waitFor();
                BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
                System.out.println("The process " + p.pid() + " has finished. " + "The file created is named: " + bfr.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {

        }


    }

    public static void main(String[] args) {
        Main m = new Main();
        m.launch();
    }
}