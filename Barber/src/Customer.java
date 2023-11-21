public class Customer implements Runnable {
    private String name;
    private BarberShop bs;


    public Customer(String name, BarberShop bs) {
        this.name = name;
        this.bs = bs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BarberShop getBs() {
        return bs;
    }


    public void setBs(BarberShop bs) {
        this.bs = bs;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", bs=" + bs +
                '}';
    }

    @Override
    public void run() {
        while (true) {
            bs.customerArrives(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
