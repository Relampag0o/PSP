import java.io.*;
import java.net.Socket;

public class Client {


    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 1999);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println(reader.readLine());
            out.println("GET /getProducts");
            System.out.println(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Client c = new Client();
        c.run();
    }
}
