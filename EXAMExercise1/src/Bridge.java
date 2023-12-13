import java.util.concurrent.Semaphore;

public class Bridge {

    private String name;
    private Semaphore semaphore;

    // arguments

    private int carCrossesTheBridge;
    private int boatCrossesTheBridge;

    private int amountCars;


    public Bridge(String name, int amountCars, int carCrossesTheBridge, int boatCrossesTheBridge) {
        this.name = name;
        this.semaphore = new Semaphore(amountCars);
        this.carCrossesTheBridge = carCrossesTheBridge;
        this.boatCrossesTheBridge = boatCrossesTheBridge;
        this.amountCars = amountCars;
    }


    public void carArrives(String name) {
        System.out.println("Car <" + name + "> arrives to the bridge");
        try {
            semaphore.acquire();
            System.out.println("Car <" + name + "> crosses the bridge");
            Thread.sleep(carCrossesTheBridge);
            System.out.println("Car <" + name + "> leaves the bridge");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public  void boatArrives(String name) {
        System.out.println("Boat arrives. Stopping traffic to elevate the bridge.");
        try {
            semaphore.acquire(amountCars);
            System.out.println("There arent cars. Elevating bridge and crossing..");
            Thread.sleep(boatCrossesTheBridge);
            System.out.println("Boat has crossed the bridge. Traffic resumes.");
            semaphore.release(amountCars);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
