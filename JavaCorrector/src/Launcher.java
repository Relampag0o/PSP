import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Launcher {
    public LinkedList<Entry> entries;
    public LinkedList<Integer> outputs;

    public Launcher() {
        this.entries = new LinkedList<Entry>();
        this.outputs = new LinkedList<Integer>();
        generateEntries();
    }


    public void generateEntries() {
        Random r = new Random(2);
        for (int i = 0; i < 5; i++) {
            entries.add(new Entry(r.nextInt(1, 100), r.nextInt(1, 100)));
            outputs.add(entries.get(i).getResult());
        }
    }

    public void show() {
        for (int i = 0; i < entries.size(); i++) {
            System.out.println("num1:" + entries.get(i).getNum1() + " num2: " + entries.get(i).getNum2());
            System.out.println("result: " + outputs.get(i));

        }

    }

    public void launch() throws IOException {

        for (int i = 0; i < entries.size(); i++) {
            ProcessBuilder pb = new ProcessBuilder("java", "AdditionExe", entries.get(i).getNum1() + "", entries.get(i).getNum2() + "");
            Process p = pb.start();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = bfr.readLine()) != null) {
                int result = Integer.parseInt(line);
                if (outputs.get(i) == result) {
                    System.out.println("Test passed." + " Result expected: " +
                            outputs.get(i) + " Provided: " + result);

                } else
                    System.out.println("Test not passed." + " Result expected: " +
                            outputs.get(i) + " Provided: " + result);
            }


        }

    }


    public static void main(String[] args) throws IOException {
        Launcher l = new Launcher();
        l.show();
        l.launch();


    }
}