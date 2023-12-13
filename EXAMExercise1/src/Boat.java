public class Boat implements Runnable {

    private String name;
    private Bridge bridge;


    // arguments
    private int delay;


    public Boat(String name, Bridge bridge, int delay) {
        this.name = name;
        this.bridge = bridge;
        this.delay = delay;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delay);
                bridge.boatArrives(this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
