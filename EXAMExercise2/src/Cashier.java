import java.util.concurrent.Semaphore;

public class Cashier  {


    private String name;
    private int id;
    private Supermarket supermarket;
    private int usages;

    private int delay;

    private Boolean underUsage;

    private Semaphore semaphore;
    private int rewardedNumber;


    public Cashier(String name, int id, int delay, Supermarket supermarket, int amountOfCustomersBeforeMaintenance, int attemptingCustomer, int rewardedNumber) {
        this.name = name;
        this.id = id;
        this.supermarket = supermarket;
        this.usages = amountOfCustomersBeforeMaintenance;
        this.underUsage = false;
        this.semaphore = new Semaphore(1);
        this.rewardedNumber = rewardedNumber;
        this.delay = delay;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Supermarket getSupermarket() {
        return supermarket;
    }

    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }

    public int getUsages() {
        return usages;
    }

    public void setUsages(int usages) {
        this.usages = usages;
    }

    public Boolean getUnderUsage() {
        return underUsage;
    }

    public void setUnderUsage(Boolean underUsage) {
        this.underUsage = underUsage;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public int getRewardedNumber() {
        return rewardedNumber;
    }

    public void setRewardedNumber(int rewardedNumber) {
        this.rewardedNumber = rewardedNumber;
    }

    public void customerArrives(String name) {
        System.out.println("Customer<" + name + "> arrives to the queue");
        try {
            semaphore.acquire();
            System.out.println("Customer<" + name + "> assigned to cashier: " + this.name);
            System.out.println("Cashier<" + name + "> is attempting " + "Customer <" + name + ">");
            System.out.println("Cashier<" + name + "> is under usage");
            System.out.println("Cashier<" + name + "> is stopping for " + delay);
            Thread.sleep(delay);
            supermarket.setAmountOfSales(supermarket.getAmountOfSales() + 1);
            if (supermarket.getAmountOfSales() == rewardedNumber) {
                System.out.println("Welcome! You are the customer number " + supermarket.getAmountOfSales() + "You have been rewarded!");
            }
            semaphore.release();




        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
