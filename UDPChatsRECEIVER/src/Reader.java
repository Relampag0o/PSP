import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Reader implements Runnable {


    public void run() {

        try {
            while (true) {
                DatagramSocket socket = new DatagramSocket(1999);
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                byte[] data = receivePacket.getData();
                String message = new String(data, 0, receivePacket.getLength());
                System.out.println("Message received: " + message);
                socket.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
