public class Cannibal implements Runnable {
    private String name;
    private Canoe c;


    public Cannibal(String name, Canoe c) {
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.cannibalArrives(this.name);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
