import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Sender implements Runnable {


    public void run() {
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                DatagramSocket socket = new DatagramSocket();
                System.out.println("Insert your message:");
                String message = sc.nextLine();
                InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
                int port = 12345;
                DatagramPacket sendPacket = new DatagramPacket(message.getBytes(), message.length(), IPAddress, port);
                socket.send(sendPacket);
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}