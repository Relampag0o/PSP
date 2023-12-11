public class Boatman extends Thread {
    private String name;
    private Canoe canoe;

    public Boatman(String name, Canoe canoe) {
        this.name = name;
        this.canoe = canoe;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);
                canoe.disembark();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
