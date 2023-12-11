public class Cannibal extends Thread {

    private String name;
    private Canoe canoe;


    public Cannibal(String name, Canoe canoe) {
        this.name = name;
        this.canoe = canoe;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                canoe.cannibalArrives();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
