import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "Hello World 1234 2394uu32497";
            byte[] sendData = message.getBytes();
            InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
            int port = 5000;
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            socket.send(sendPacket);

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}