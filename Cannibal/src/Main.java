public class Main {


    public static void main(String[] args) {

        Canoe c = new Canoe();
        Boatman boatman = new Boatman("Joselu", c);
        Thread threadBoatman = new Thread(boatman);
        threadBoatman.start();

        for (int i = 0; i < 5; i++) {
            Missionary missionary = new Missionary("Missionary_" + i, c);
            Thread mthread = new Thread(missionary);
            mthread.start();

        }

        for (int i = 0; i < 5; i++) {
            Cannibal cannibal = new Cannibal("Cannibal" + i, c);
            Thread cthread = new Thread(cannibal);
            cthread.start();
        }


    }


}