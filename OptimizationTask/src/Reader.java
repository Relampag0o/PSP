import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements Runnable {
    private String file;
    private int counter;

    public Reader(String file) {
        this.file = file;
        this.counter = 0;
    }


    public String getFile() {
        return file;
    }

    public int getCounter() {
        return counter;
    }

    @Override

    public void run() {

        BufferedReader bfr = null;
        try {

            bfr = new BufferedReader(new FileReader(this.file));
            String line = "";

            while ((line = bfr.readLine()) != null) {

                counter += Integer.parseInt(line);

            }


        } catch (Exception e) {

        } finally {
            try {
                bfr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
