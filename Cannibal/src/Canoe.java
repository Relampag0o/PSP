
public class Canoe {
    private String name;
    private int maxCapacity;
    private int passengers;
    private Boolean missionaryIn;

    public Canoe() {
        this.name = "Canoe";
        this.maxCapacity = 5;
        this.passengers = 0;
        this.missionaryIn = false;
    }


    public synchronized void cannibalArrives() {
        while (!missionaryIn || passengers >= maxCapacity) {
            try {
                if (!missionaryIn)
                    System.out.println("I am the Cannibal" + Thread.currentThread().getName() + " and I cant get in the boat because there is no missionary in");
                else
                    System.out.println("I am the Cannibal" + Thread.currentThread().getName() + " and I cant get in the boat because the boat is full");
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("I am the Cannibal" + Thread.currentThread().getName() + " and I am getting into the boat");
        try {
            Thread.sleep(3000);
            this.passengers++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public synchronized void missionaryArrives() {
        while (missionaryIn || passengers >= maxCapacity) {
            try {
                System.out.println("I am the Missionary" + Thread.currentThread().getName() + " and I cant get in the boat because there is a missionary in already or capacity for me");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        try {
            System.out.println("I am the Missionary" + Thread.currentThread().getName() + " and I am getting into the boat");
            missionaryIn = true;
            passengers++;
            Thread.sleep(3000);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void disembark() {

        System.out.println("Disembarking...");
        try {
            Thread.sleep(10000);
            passengers = 0;
            missionaryIn = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}








