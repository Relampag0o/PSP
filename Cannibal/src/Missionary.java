public class Missionary extends Thread {
    private String name;
    private Canoe canoe;


    public Missionary(String name, Canoe canoe) {
        this.name = name;
        this.canoe = canoe;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                canoe.missionaryArrives();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
