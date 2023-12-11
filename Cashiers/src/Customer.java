import java.util.Random;

public class Customer implements Runnable {

    private int id;

    private String name;
    private BranchOffice branchOffice;


    public Customer(int id, String name, BranchOffice branchOffice) {
        this.id = id;
        this.name = name;
        this.branchOffice = branchOffice;
    }


    @Override
    public void run() {
        while (true) {
            Random r = new Random();
            if (id % 2 == 0) {
                try {
                    Thread.sleep(3000);
                    branchOffice.deposit(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                try {
                    Thread.sleep(3000);
                    branchOffice.withdraw(r.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
