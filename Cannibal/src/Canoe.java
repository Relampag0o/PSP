public class Canoe {
    private int capacity;
    private boolean missionaryIn;


    public Canoe() {
        this.capacity = 4;
        missionaryIn = false;
    }

    public synchronized void cannibalArrives(String name) {

        if (capacity > 0 && missionaryIn) {
            capacity--;
            System.out.println("Cannibal " + name + " getting in.");
        } else {
            try {
                System.out.println("Cannibal " + name + " getting blocked.");
                wait();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }


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
        if (!missionaryIn && capacity > 0) {
            missionaryIn = true;
            capacity--;
            System.out.println("Missionary " + name + " getting in the canoe.");
        } else {
            try {
                System.out.println("Missionary " + name + " getting blocked.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


}


