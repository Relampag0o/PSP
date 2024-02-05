import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Map;

public class Server implements Runnable {
    private Map<String, Integer> candidates;
    private int counter;


    public Server() {
        this.candidates = new HashMap<String, Integer>();
        this.candidates.put("PSOE", 0);
        this.candidates.put("VOX", 0);
        this.candidates.put("PODEMOS", 0);
        this.candidates.put("PACMA", 0);
        this.candidates.put("PP", 0);
        this.candidates.put("BLANK", 0);
        this.candidates.put("NULL", 0);
        this.counter = 0;
    }

    public void showVotes() {
        System.out.println("PSOE: " + this.candidates.get("PSOE"));
        System.out.println("VOX: " + this.candidates.get("VOX"));
        System.out.println("PODEMOS: " + this.candidates.get("PODEMOS"));
        System.out.println("PACMA: " + this.candidates.get("PACMA"));
        System.out.println("PP: " + this.candidates.get("PP"));
        System.out.println("BLANK: " + this.candidates.get("BLANK"));
        System.out.println("NULL: " + this.candidates.get("NULL"));
    }

    @Override
    public void run() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(12345);
            while (counter < 100) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                byte[] data = receivePacket.getData();
                String vote = new String(data, 0, receivePacket.getLength());
                System.out.println("Received vote: " + vote);
                if (this.candidates.containsKey(vote)) {
                    this.candidates.put(vote, this.candidates.get(vote) + 1);
                }
                this.counter++;


            }
            showVotes();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }


    }
}
