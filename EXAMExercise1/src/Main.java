// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int amountOfThreads = Integer.parseInt(args[0]);
        int amountCarsThatCrossesTheBridge = Integer.parseInt(args[1]);
        int carDelay = Integer.parseInt(args[2]);
        int timesThatTakesForTheCar = Integer.parseInt(args[3]);
        int boatDelay = Integer.parseInt(args[4]);
        int timesThatTakesForTheBoat = Integer.parseInt(args[5]);

        Bridge bridge = new Bridge("Bridge", amountOfThreads, amountCarsThatCrossesTheBridge, boatDelay);
        Boat boat = new Boat("Boat", bridge, boatDelay);
        Thread boatThread = new Thread(boat);
        boatThread.start();
        for (int i = 0; i < amountOfThreads; i++) {

            Car car = new Car("Car" + i, bridge, carDelay);
            Thread carThread = new Thread(car);
            carThread.start();

        }


    }
}