import java.util.LinkedList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Tower tower = new Tower("Tower");
        Terminal[] terminals = new Terminal[4];
        Terminal terminal1 = new Terminal("Terminal1");
        Terminal terminal2 = new Terminal("Terminal2");
        Terminal terminal3 = new Terminal("Terminal3");
        Terminal terminal4 = new Terminal("Terminal4");
        Technician t1 = new Technician("T1", terminal1);
        Thread thec = new Thread(t1);
        thec.start();
        terminals[0] = terminal1;
        terminals[1] = terminal2;
        terminals[2] = terminal3;
        terminals[3] = terminal4;
        tower.addTerminals(terminals);

        for (int i = 0; i < 5; i++) {
            Plane p = new Plane(i,"P" + i, tower);
            Thread t = new Thread(p);
            t.start();

        }

    }
}