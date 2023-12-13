public class Supermarket {
    private String name;
    private int amountOfSales;
    public Cashier[] cashiers;


    public Supermarket(String name, int amountOfSales, Cashier[] cashiers) {
        this.name = name;
        this.amountOfSales = amountOfSales;
        this.cashiers = cashiers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmountOfSales() {
        return amountOfSales;
    }

    public void setAmountOfSales(int amountOfSales) {
        this.amountOfSales = amountOfSales;
    }

    public Cashier[] getCashiers() {
        return cashiers;
    }

    public void setCashiers(Cashier[] cashiers) {
        this.cashiers = cashiers;
    }
}
