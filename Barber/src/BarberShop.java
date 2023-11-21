public class BarberShop {
    private boolean barberSleeping = true;
    private int availableChairs = 5;

    public BarberShop() {

    }


    public synchronized void barberWorks(String name) {
        while (availableChairs == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        barberSleeping = false;
        notify();


    }

    public synchronized void customerArrives(String name) {

        while (barberSleeping) {
            try {
                if (availableChairs > 0) {
                    availableChairs--;
                    wait();
                } else
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();

        System.out.println("Customer " + name + " is getting attended");
        barberSleeping = false;
        availableChairs++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Customer " + name + " was attended");


    }


}
