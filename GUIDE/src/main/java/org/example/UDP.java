package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class UDP {
     private DatagramSocket socket;
        private DatagramPacket receivePacket;

    // CLIENT
    public void client() {
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

    public void serverLauncher() {
        // LANZADOR:
        DatagramSocket socket = null;
        // INSTANCIAR LA CLASE SERVERTHREAD:
        try {
            socket = new DatagramSocket(8081);
            System.out.println("Server started on port 8081");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                // PASARLE A LA CLASE LOS ARGUMENTOS NECESARIOS
                //Server server = new Server(number, socket, receivePacket);

                // CORRER SERVIDOR:
                /*
                Thread thread = new Thread(server);
                thread.start();

                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    public void manejarServer() {

        // private DatagramSocket socket;
        //    private DatagramPacket receivePacket;


        try {

            byte[] data = receivePacket.getData();
            System.out.println("Conection started");
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            System.out.println("Waiting for client to send a number");
            String number = new String(data, 0, receivePacket.getLength());
            System.out.println("Received: " + number);
            int clientNumber = Integer.parseInt(number);
            /*
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

             */


        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    public static void main(String[] args) {


    }
}