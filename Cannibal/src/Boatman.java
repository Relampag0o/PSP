public class Boatman implements Runnable {
    String name;
    Canoe c;


    public Boatman(String name, Canoe c) {
        this.name = name;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            // withouth the sync doesnt work idk why.
            synchronized (c) {
                if (c.getCapacity() == 0) {
                    System.out.println("Disembarking..");
                    try {
                        Thread.sleep(3000);
                        c.setCapacity(4);
                        c.setMissionaryIn(false);
                        c.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
