import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable {
    private String[] file;
    private int counter;

    public Reader(String[] files) {
        this.file = files;
        this.counter = 0;
    }


    public int getCounter() {
        return counter;
    }

    @Override

    public void run() {

        BufferedReader bfr = null;
        try {

            for (int i = 0; i < this.file.length; i++) {
                bfr = new BufferedReader(new FileReader(this.file[i]));
                String line = "";


                while ((line = bfr.readLine()) != null) {

                    counter += Integer.parseInt(line);


                }
            }
            System.out.println("I have read " + this.file[0] + this.file[1] + counter);
            bfr.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
