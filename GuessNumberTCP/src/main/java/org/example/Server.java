package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    int number;
    ServerSocket serverSocket;
    Socket clientSocket;

    public Server(int number, ServerSocket serverSocket, Socket socket) {
        this.number = number;
        this.serverSocket = serverSocket;
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("SERVER CLASS STARTED WORKING!");
            BufferedReader bfr = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String clientMessage = bfr.readLine();
            System.out.println("The client sent: " + clientMessage);
            int clientNumber = Integer.parseInt(clientMessage);
            if (clientNumber == number) {
                bfw.write("Congratulations! You guessed the number!");
                bfw.newLine();
                bfw.flush();
            } else {
                bfw.write("Sorry! The number is not correct. Try again!");
                bfw.newLine();
                bfw.flush();
            }


            bfr.close();
            bfw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
