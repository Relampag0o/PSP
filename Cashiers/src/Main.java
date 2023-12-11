// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BranchOffice bbva = new BranchOffice("BBVA");

        for (int i = 0; i < 6; i++) {

            Customer customer = new Customer(i, "Customer " + i, bbva);
            Thread thread = new Thread(customer);
            thread.start();

        }
        bbva.addMoney();
    }
}