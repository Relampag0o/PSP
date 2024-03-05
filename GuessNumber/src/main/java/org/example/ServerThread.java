package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ServerThread {
    public int generateRandomNumber() {
        // Press Ctrl+Alt+L to reformat the code.
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        DatagramSocket socket = null;
        ServerThread serverThread = new ServerThread();

        try {
            socket = new DatagramSocket(8081);
            System.out.println("Server started on port 8081");

            while (true) {
                int number =  serverThread.generateRandomNumber();
                System.out.println("The number generated is " + number);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                Server server = new Server(number, socket, receivePacket);

                // run server:
                Thread thread = new Thread(server);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}