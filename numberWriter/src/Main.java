import java.util.LinkedList;
import java.util.Random;

public class Main {
    public LinkedList<Process> processes;


    public Main() {

        this.processes = new LinkedList<Process>();
    }

    public int generateRandom() {
        Random r = new Random();
        return r.nextInt();

    }


    public void launch() {

        try {
            for (int i = 0; i < 5; i++) {
                ProcessBuilder pb = new ProcessBuilder("java", "Writer", i + "");
                Process p = pb.start();

            }



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Main m = new Main();
        m.launch();


    }
}