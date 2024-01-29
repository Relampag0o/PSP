import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Random;

public class Sender implements Runnable{


    public void run() {

        try {
            while (true) {
                Socket socket = new Socket("127.0.0.1", 1999);
                OutputStream outputStream = socket.getOutputStream();


                byte[] fileBytes = Files.readAllBytes(new File("jose.txt").toPath());

                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeInt(fileBytes.length);

                outputStream.write(fileBytes, 0, fileBytes.length);
                outputStream.flush();

                outputStream.close();
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
