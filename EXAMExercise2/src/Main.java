// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int numberOfCustomers = Integer.parseInt(args[0]);
        int numberOfCashiers = Integer.parseInt(args[1]);
        int amountOfCustomersBeforeMaintenance = Integer.parseInt(args[2]);
        int delay = Integer.parseInt(args[3]);
        int attemptingCustomer = Integer.parseInt(args[4]);
        int rewardedNumber = Integer.parseInt(args[5]);
        int numberOfSales = Integer.parseInt(args[6]);
        Supermarket mercadona = new Supermarket("Mercadona", numberOfSales, new Cashier[numberOfCashiers]);

        Cashier[] cashiers = new Cashier[numberOfCashiers];
        Cashier cashier1 = new Cashier("Cashier 1", 1, delay, mercadona, amountOfCustomersBeforeMaintenance, attemptingCustomer, rewardedNumber);
        Cashier cashier2 = new Cashier("Cashier 2", 2, delay, mercadona, amountOfCustomersBeforeMaintenance, attemptingCustomer, rewardedNumber);
        Cashier cashier3 = new Cashier("Cashier 3", 3, delay, mercadona, amountOfCustomersBeforeMaintenance, attemptingCustomer, rewardedNumber);
        Cashier cashier4 = new Cashier("Cashier 4", 4, delay, mercadona, amountOfCustomersBeforeMaintenance, attemptingCustomer, rewardedNumber);
        Cashier cashier5 = new Cashier("Cashier 5", 5, delay, mercadona, amountOfCustomersBeforeMaintenance, attemptingCustomer, rewardedNumber);


        for (int i = 0; i < numberOfCustomers; i++) {
            Customer customer = new Customer("Customer " + i, new Cashier( "cashier", 1, delay, mercadona, amountOfCustomersBeforeMaintenance, attemptingCustomer, rewardedNumber), delay);
            Thread t = new Thread(customer);
            t.start();

        }


    }
}