import java.util.Random;
import java.util.concurrent.Semaphore;

public class BranchOffice {
    private String name;
    private int money;

    private Semaphore[] cashiers;


    public BranchOffice(String name) {
        this.name = name;
        this.money = 1000;
        this.cashiers = new Semaphore[2];
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new Semaphore(1);
        }
    }

    public void deposit(int money) {

        Random r = new Random();
        int cashier = r.nextInt(cashiers.length);
        System.out.println("Customer wants to deposit " + money + "€ in the cashier " + cashier);
        try {
            System.out.println("Depositing " + money + "€ in the cashier " + cashier);
            cashiers[cashier].acquire();
            Thread.sleep(2000);
            System.out.println("The deposit was successful. The branch office has " + (money + this.money) + "€");
            cashiers[cashier].release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void withdraw(int money) {
        Random r = new Random();
        int cashier = r.nextInt(cashiers.length);
        System.out.println("Customer wants to withdraw " + money + "€ in the cashier " + cashier);
        if (this.money < money) {
            System.out.println("The branch office doesn't have enough money");
            return;
        }
        try {
            System.out.println("Withdrawing " + money + "€ in the cashier " + cashier);
            cashiers[cashier].acquire();
            Thread.sleep(2000);
            System.out.println("The withdraw was successful. The branch office has " + (this.money - money) + "€");
            cashiers[cashier].release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void addMoney() {

        while (true) {
            try {
                Thread.sleep(8000);
                Random r = new Random();
                int money = r.nextInt(3000);
                this.money += money;
                System.out.println("The branch office has added " + money + "€. It now has " + this.money + "€");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }


    }


}
