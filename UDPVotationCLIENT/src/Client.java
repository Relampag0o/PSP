import javax.xml.crypto.Data;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client implements Runnable {

    private String[] options;
    private int counter;


    public Client() {
        this.options = new String[]{"PSOE", "VOX", "PODEMOS", "PACMA", "PP", "BLANK", "NULL"};
        this.counter = 0;
    }


    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            while (counter < 100) {
                String vote = this.options[(int) (Math.random() * this.options.length)];
                byte[] sendData = vote.getBytes();
                InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
                int port = 12345;
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
                System.out.println("Sent vote: " + vote);
                this.counter++;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
