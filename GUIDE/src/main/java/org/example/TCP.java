package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCP {


    public void client() {
        try{
            Scanner scStrings = new Scanner(System.in);
            Socket socket = new Socket("localhost", 8081);
            System.out.println("Connected to server!");
            System.out.println("Enter the number you want to send to the server");
            String number = scStrings.nextLine();
            System.out.println("Sending the number to the server");
            BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            bfw.write(number + "\n");
            bfw.flush();
            System.out.println("Number sent to the server");
            String message = bfr.readLine();
            System.out.println("Received from server: " + message);


            bfr.close();
            bfw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void serverLauncher() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8081);
            while (true) {

                System.out.println("Server started on port 8081");
                System.out.println("Waiting for a client to connect");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                System.out.println("Giving the server the rest of functionality");
                // CAMBIAR NOMBRES DE LAS VARIABLES
                /*
                Server server = new Server(number, serverSocket, clientSocket);
                new Thread(server).start();
                                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void server(){

        // ATRIBUTOS PARA LA CLASE SERVIDOR
        /*
        ServerSocket serverSocket;
        Socket clientSocket;
        // CONSTRUCTOR DE LA CLASE SERVIDOR
         public Server(int number, ServerSocket serverSocket, Socket socket) {
        this.number = number;
        this.serverSocket = serverSocket;
        this.clientSocket = socket;
    }
         */

        // todo: CODIGO:
        /*
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

         */
    }
}
