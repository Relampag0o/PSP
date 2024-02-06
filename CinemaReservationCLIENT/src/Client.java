import java.io.*;
import java.net.Socket;

public class Client {

    public void run() {

        try {
            Socket socket = new Socket("127.0.0.1", 1999);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = reader.readLine();
            System.out.print(line);
            /*
            while((line=reader.readLine())!=null){
                System.out.print(line);
            }


             */


            writer.newLine();
            writer.flush();




            // closing
            writer.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
