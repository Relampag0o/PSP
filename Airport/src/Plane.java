import java.util.concurrent.Semaphore;

public class Plane implements Runnable {
    private String name;
    private Tower tower;

    private int id;


    public Plane(int id, String name, Tower tower) {
        this.id = id;
        this.name = name;
        this.tower = tower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(4000);
                Terminal terminal = tower.assignTerminal();
                terminal.getTracks().acquire();
                if (id % 2 == 0)
                    System.out.println("I am the plane " + name + " and I am going to take off in the terminal " + terminal.getName());
                else
                    System.out.println("I am the plane " + name + " and I have taken off in the terminal " + terminal.getName());


                Thread.sleep(3000);
                terminal.setUsages(terminal.getUsages() + 1);
                System.out.println("I am the plane " + name + " and I am quitting the terminal " + terminal.getName());
                terminal.getTracks().release();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
