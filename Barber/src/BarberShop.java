public class BarberShop {
    private boolean barberSleeping;
    private int availableChairs;

    private int maxChairs = 10;

    public BarberShop() {
        this.barberSleeping = true;
        this.availableChairs = maxChairs;

    }


    public synchronized void barberWorks(String name) {
        while (availableChairs == maxChairs) {
            try {
                System.out.println("Barber " + name + " sleeping. No customers available.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        barberSleeping = false;
        availableChairs++;



    }

    public synchronized void customerArrives(String name) {
        if (availableChairs > 0) {
            if (availableChairs == maxChairs) {
                System.out.println("Waking up barber..");
                notify();
            }
            availableChairs--;
        } else
            System.out.println("Customer " + name + "leaving!");


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer " + name + " was attended");


    }


}
