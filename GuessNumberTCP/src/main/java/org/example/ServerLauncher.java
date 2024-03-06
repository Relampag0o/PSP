package org.example;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLauncher {
    public int generateRandomNumber() {
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8081);
            while (true) {
                int number = new ServerLauncher().generateRandomNumber();
                System.out.println("The number to guess is: " + number);
                System.out.println("Server started on port 8081");
                System.out.println("Waiting for a client to connect");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                System.out.println("Giving the server the rest of functionality");
                Server server = new Server(number, serverSocket, clientSocket);
                new Thread(server).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
