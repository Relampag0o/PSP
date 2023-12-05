import java.sql.PreparedStatement;

public class Canoe {
    private int capacity;
    private boolean missionaryIn;


    public Canoe() {
        this.capacity = 4;
        missionaryIn = false;
    }

    public synchronized void cannibalArrives(String name) {
        while (capacity == 0 || !missionaryIn) {
            System.out.println("Cannibal " + name + " getting blocked.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        capacity--;
        System.out.println("Cannibal " + name + " getting in.");
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isMissionaryIn() {
        return missionaryIn;
    }

    public void setMissionaryIn(boolean missionaryIn) {
        this.missionaryIn = missionaryIn;
    }

    public synchronized void missionaryArrives(String name) {
        while (capacity == 0 || missionaryIn) {
            System.out.println("Missionary " + name + " getting blocked.");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        missionaryIn = true;
        capacity--;
        System.out.println("Missionary " + name + " getting in the canoe.");
    }
}








