import java.util.LinkedList;

public class Table {
    public LinkedList<Ingredients> ingredients;
    private Boolean ingredientsAdded;

    public Table() {
        ingredients = new LinkedList<Ingredients>();
        ingredientsAdded = false;
    }

    public synchronized void smoke(Ingredients ingredient, String name) {

        while (!ingredientsAdded || ingredient == ingredients.get(0) || ingredient == ingredients.get(1)) {
            try {
                System.out.println("I am the " + name + " and i cant smoke because there are no ingredients in the table or the table already contains my ingredient.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("I am the smoker " + name + " and I smoke " + ingredients.get(0) + " , " + ingredients.get(1) + " and " + ingredient);
        try {
            Thread.sleep(5000);
            System.out.println("Im done smoking");
            ingredientsAdded = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public synchronized void addIngredients(LinkedList<Ingredients> ingredients) {

        while (ingredientsAdded) {
            try {
                System.out.println("I cant add ingredients because they are already in the table.");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Adding ingredients...");
        this.ingredients = ingredients;
        System.out.println(" Ingredients added." + "The table contains now " + ingredients.get(0) + " and " + ingredients.get(1));
        ingredientsAdded = true;
        notifyAll();
    }


}
