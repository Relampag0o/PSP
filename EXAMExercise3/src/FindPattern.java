public class FindPattern implements Runnable {

    private int[] array;
    private Boolean found;
    private int pattern;


    public FindPattern(int[] array, int number) {
        this.array = array;
        this.found = false;
        this.pattern = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == pattern) {
                found = true;
                return;
            }
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public int getPattern() {
        return pattern;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
    }
}
