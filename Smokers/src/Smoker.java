public class Smoker implements Runnable {
    private String name;
    private Ingredients ingredient;
    private Table table;

    public Smoker(String name, Ingredients ingredient, Table table) {
        this.name = name;
        this.ingredient = ingredient;
        this.table = table;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                table.smoke(ingredient,this.name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredients getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
