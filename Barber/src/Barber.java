public class Barber implements Runnable{
    private String name;
    private BarberShop bs;


    public Barber(String name, BarberShop bs) {
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
        return "Barber{" +
                "name='" + name + '\'' +
                ", bs=" + bs +
                '}';
    }

    @Override
    public void run(){
        while (true) {
            bs.barberWorks(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
