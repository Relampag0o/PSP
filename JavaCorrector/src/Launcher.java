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
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            entries.add(new Entry(r.nextInt(1, 100), r.nextInt(1, 100)));
            outputs.add(entries.get(i).getNum1() + entries.get(i).getNum2());
        }
    }

    public void show() {
        for (int i = 0; i < entries.size(); i++) {
            System.out.println("num1:" + entries.get(i).getNum1() + " num2: " + entries.get(i).getNum2());
            System.out.println("result: " + outputs.get(i));

        }

    }

    public void launch() {

        for (Entry e: entries){
                ProcessBuilder pb = new ProcessBuilder("java","Addition", (String) e.getNum1(),e.getNum2());


        }

    }


    public static void main(String[] args) {
        Launcher l = new Launcher();
        l.show();


    }
}