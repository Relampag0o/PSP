import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public void launch() {
        ProcessBuilder pb = new ProcessBuilder("", "", "");
        try {
            Process p = pb.start();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("", "", "");
        try {
            Process p = pb.start();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}