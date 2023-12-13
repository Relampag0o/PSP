import java.util.Set;
import java.util.concurrent.Semaphore;

public class Tower {

    private String name;
    public Terminal[] terminals;


    public Tower(String name) {
        this.name = name;
        this.terminals = new Terminal[]{};
    }

    public void addTerminals(Terminal[] terminals) {
        this.terminals = terminals;

    }

    public synchronized Terminal assignTerminal() {
        int smallest = terminals[0].getUsages();
        Terminal t = terminals[0];

        for (Terminal terminal : terminals) {
            System.out.println(terminal.getName() + " usages: " + terminal.getUsages());
            if (terminal.getUsages() < smallest && !terminal.getUnderMaintainance()) {
                smallest = terminal.getUsages();
                t = terminal;
            }
        }
        return t;
    }


}
