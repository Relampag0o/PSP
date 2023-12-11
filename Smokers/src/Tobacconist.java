import java.util.LinkedList;

public class Tobacconist implements Runnable {
    private String name;
    private LinkedList<Ingredients> ingredients;

    private Table table;


    public Tobacconist(String name, Table table) {
        this.name = name;
        this.ingredients = new LinkedList<Ingredients>();
        this.ingredients.add(Ingredients.TOBACCO);
        this.ingredients.add(Ingredients.PAPER);
        this.ingredients.add(Ingredients.MATCHES);
        this.table = table;
    }

    public LinkedList<Ingredients> generateIngredients() {
        Ingredients ingredient1 = null;
        Ingredients ingredient2 = null;
        LinkedList<Ingredients> ingredients = new LinkedList<Ingredients>();

        while (ingredient1 == ingredient2 || ingredient1 == null || ingredient2 == null) {

            ingredient1 = Ingredients.values()[(int) (Math.random() * 3)];
            ingredient2 = Ingredients.values()[(int) (Math.random() * 3)];

        }
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        return ingredients;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                table.addIngredients(generateIngredients());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
