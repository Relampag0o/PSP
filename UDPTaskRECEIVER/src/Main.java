import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(5000);
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            byte[] data = receivePacket.getData();
            String message = new String(data, 0, receivePacket.getLength());
            Thread reader = new Thread(new Reader(message));
            reader.start();

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}