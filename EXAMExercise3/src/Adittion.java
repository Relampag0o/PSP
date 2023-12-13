public class Adittion implements Runnable {

    private int counter;
    private int[] array;

    public Adittion(int[] array) {
        this.array = array;

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {

        for (int i = 0; i < array.length; i++) {
            counter += array[i];

        }


    }


}
