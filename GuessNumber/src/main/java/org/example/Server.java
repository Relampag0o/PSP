package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server implements Runnable {


    private int number;
    private DatagramSocket socket;
    private DatagramPacket receivePacket;

    public Server(int number) {
        this.number = number;
    }

    public Server(int number, DatagramSocket socket, DatagramPacket receivePacket) {
        this.number = number;
        this.socket = socket;
        this.receivePacket = receivePacket;


    }


    @Override
    public void run() {
        try {

            byte[] data = receivePacket.getData();
            System.out.println("Conection started");
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println("Waiting for client to send a number");
            String number = new String(data, 0, receivePacket.getLength());
            System.out.println("Received: " + number);
            int clientNumber = Integer.parseInt(number);
            if (clientNumber == this.number) {
                System.out.println("Client guessed the number");
                String message = "Congratulations! You guessed the number!";
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
                System.out.println("Message sent to client");
            } else {
                System.out.println("Client did not guess the number");
                String message = "Sorry, the number is not correct. Try again!";
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
                System.out.println("Message sent to client");
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
