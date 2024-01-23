import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Reader implements Runnable {

    public void run() {
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(1999);
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String message = in.readLine();
                System.out.println("Message received: " + message);
                int addition = Integer.parseInt(message.split(";")[0]) + Integer.parseInt(message.split(";")[1]);
                System.out.println("Addition: " + addition);
                out.println("Addition:" + message.split(";")[0] + " + " + message.split(";")[1] + " = " + (Integer.parseInt(message.split(";")[0]) + Integer.parseInt(message.split(";")[1])));

                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
                Thread.sleep(2000);
                System.out.println("Waiting to stablish a new connection..");


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
