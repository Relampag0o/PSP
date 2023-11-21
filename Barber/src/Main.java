// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BarberShop bs = new BarberShop();
        Barber victor = new Barber("Victor", bs);
        Thread barber = new Thread(victor);
        Customer c1 = new Customer("c1", bs);
        Customer c2 = new Customer("c2", bs);
        Customer c3 = new Customer("c3", bs);
        Customer c4 = new Customer("c3", bs);
        Thread customer1 = new Thread(c1);
        Thread customer2 = new Thread(c2);
        Thread customer3 = new Thread(c3);
        Thread customer4 = new Thread(c4);
        barber.start();
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
    }
}