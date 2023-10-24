import java.io.*;
import java.util.LinkedList;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Launcher {
    public LinkedList<Entry> entries;
    public LinkedList<Integer> outputs;
    public LinkedList<File> files;

    public Launcher() {
        this.entries = new LinkedList<Entry>();
        this.outputs = new LinkedList<Integer>();
        this.files = new LinkedList<File>();
        generateEntries();
        chargeFiles();
    }


    public void generateEntries() {
        Random r = new Random(2);
        for (int i = 0; i < 5; i++) {
            entries.add(new Entry(r.nextInt(1, 100), r.nextInt(1, 100)));
            outputs.add(entries.get(i).getResult());
        }
    }

    public void chargeFiles() {
        File f = new File("C:\\Users\\josem\\IdeaProjects\\PSP\\JavaCorrector\\samples");
        File[] directories = f.listFiles();
        assert directories != null;
        // I got no clue what this lane does but seems to be checking if dirs !=null and throws an exception.
        // the ide suggested it.
        for (File fi : directories) {
            if (fi.getName().contains("class")) {
                files.add(fi);
            }
        }
    }

    public void show() {
        for (int i = 0; i < entries.size(); i++) {
            System.out.println("num1:" + entries.get(i).getNum1() + " num2: " + entries.get(i).getNum2());
            System.out.println("result: " + outputs.get(i));

        }

    }

    public void launch() throws IOException {
        // TODO: ASK IF THERE IS ANY WAY TO EXECUTE FEW PROCESSES AT ONCE
        // ONE FOR EACH FILE SO THE READING GOES FASTER.

        for (File f : files) {
            System.out.println("Executing " + f.getName());
            for (int i = 0; i < entries.size(); i++) {
                ProcessBuilder pb = new ProcessBuilder("java", f.getName().split("\\.")[0], entries.get(i).getNum1() + "", entries.get(i).getNum2() + "");
                pb.directory(new File("C:\\Users\\josem\\IdeaProjects\\PSP\\JavaCorrector\\samples"));
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
    }


    public static void main(String[] args) throws IOException {
        Launcher l = new Launcher();
        l.launch();


    }
}