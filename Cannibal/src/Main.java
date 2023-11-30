public class Main {

    Canoe canoe;

    public Main() {
        canoe = new Canoe();
    }

    public static void main(String[] args) {
        Main m = new Main();
        Thread disembark = new Thread(m.disembark());
        disembark.start();
        for (int i = 0; i < 5; i++) {
            Missionary missionary = new Missionary("Missionary_" + i, m.canoe);
            Thread mthread = new Thread(missionary);
            mthread.start();

        }

        for (int i = 0; i < 5; i++) {
            Cannibal cannibal = new Cannibal("Cannibal" + i, m.canoe);
            Thread cthread = new Thread(cannibal);
            cthread.start();
        }


    }

    public Runnable disembark() {
        while (true) {
            if (canoe.getCapacity() == 0) {
                canoe.setCapacity(4);
                canoe.setMissionaryIn(false);
                System.out.println("Disembarking...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}