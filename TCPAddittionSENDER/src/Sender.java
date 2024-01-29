import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;

public class Sender implements Runnable {


    public void run() {

        try {
            while (true) {
                Random r = new Random();
                Socket socket = new Socket("127.0.0.1", 1999);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String message = r.nextInt(1000)+";"+r.nextInt(1000);
                writer.write(message);
                writer.newLine();
                writer.flush();

                writer.close();
                socket.close();



            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
