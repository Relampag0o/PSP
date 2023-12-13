public class Car implements Runnable {

    private String name;

    private Bridge bridge;
    private int delay;


    public Car(String name, Bridge bridge, int delay) {
        this.name = name;
        this.bridge = bridge;
        this.delay = delay;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(delay);
                bridge.carArrives(this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
