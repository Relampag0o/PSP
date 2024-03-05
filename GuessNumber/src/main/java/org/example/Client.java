package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        while (true) {
            try {
                Scanner scStrings = new Scanner(System.in);
                System.out.println("Client started");
                DatagramSocket socket = new DatagramSocket();
                System.out.println("Enter the number you want to send to the server");
                String number = scStrings.nextLine();
                byte[] sendData = number.getBytes();
                InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
                int port = 8081;
                System.out.println("Sending the number to the server");
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                socket.send(sendPacket);
                System.out.println("Number sent to the server");
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from server: " + message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
