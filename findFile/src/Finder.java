

import java.io.File;

public class Finder {

    private int counter = 0;

    public int getCounter() {
        return counter;
    }


    public void findFile(String dir, String filename) {
        File f = new File(dir);
        File[] files = f.listFiles();

        for (File fi : files) {
            if (fi.getName().equalsIgnoreCase(filename)) {
                this.counter++;
            }
            if (fi.isDirectory()) {
                findFile(fi.getPath(), filename);
            }

        }


    }

    public static void main(String[] args) {
        Finder f = new Finder();
        f.findFile(args[0], args[1]);
        System.out.println(f.counter);

    }
}
