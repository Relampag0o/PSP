public class Customer implements Runnable {

    private String name;
    private Cashier cashier;

    private int delay;


    public Customer(String name, Cashier cashier, int delay) {
        this.name = name;
        this.cashier = cashier;
        this.delay = delay;
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(delay);
                cashier.customerArrives(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
