import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Writer {
    public String randomString() {
        String s = "";
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            s += (char) r.nextInt(1, 100);
        }
        return s;
    }

    public void close(Closeable c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void write() {
        try {
            String name = randomString();
            File f = new File("/home/jose/Escritorio/testdelete/" + name);

            if (f.createNewFile())
                System.out.println(name);

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
        }
    }

    public static void main(String[] args) {
        Writer w = new Writer();
        w.write();

    }
}
