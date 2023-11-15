import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileWriter;
import java.util.Random;

public class Writer {

    public void close(Closeable c) {

        try {
            c.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public int writeEven() {
        Random r = new Random();
        int n = -1;

        while ((n = r.nextInt(1, 100)) % 2 != 0) ;

        return n;
    }

    public int writeOdd() {
        Random r = new Random();
        int n = -1;

        while ((n = r.nextInt(1, 100)) % 2 == 0) ;

        return n;
    }

    public void write(String option) {
        switch (option) {

            case "even":
                BufferedWriter bfw = null;
                try {
                    bfw = new BufferedWriter(new FileWriter("/home/jose/Escritorio/testdelete/evennumbers.txt",true));
                    bfw.write(String.valueOf(writeEven()) + '\n');

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    close(bfw);
                }


                break;

            case "odd":
                BufferedWriter bfw2 = null;
                try {
                    bfw2 = new BufferedWriter(new FileWriter("/home/jose/Escritorio/testdelete/oddnumbers.txt",true));
                    bfw2.write(String.valueOf(writeOdd()) + '\n');

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    close(bfw2);
                }


                break;


        }
    }


    public static void main(String[] args) {
        Writer w = new Writer();

        if (Integer.parseInt(args[0]) % 2 == 0)
            w.write("even");
        else
            w.write("odd");

    }
}
