// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        Tobacconist tobacconist = new Tobacconist("Tobacconist", table);
        Smoker smoker1 = new Smoker("Smoker1", Ingredients.TOBACCO, table);
        Smoker smoker2 = new Smoker("Smoker2", Ingredients.PAPER, table);
        Smoker smoker3 = new Smoker("Smoker3", Ingredients.MATCHES, table);

        Thread tobacconistThread = new Thread(tobacconist);
        Thread smoker1Thread = new Thread(smoker1);
        Thread smoker2Thread = new Thread(smoker2);
        Thread smoker3Thread = new Thread(smoker3);

        tobacconistThread.start();
        smoker1Thread.start();
        smoker2Thread.start();
        smoker3Thread.start();

    }
}