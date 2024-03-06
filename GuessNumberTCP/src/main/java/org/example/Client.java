package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Scanner scStrings = new Scanner(System.in);
            Socket socket = new Socket("localhost", 8081);
            System.out.println("Connected to server!");
            System.out.println("Enter the number you want to send to the server");
            String number = scStrings.nextLine();
            System.out.println("Sending the number to the server");
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bfr = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.write(number + "\n");
            out.flush();


            System.out.println("Number sent to the server");
            String message = bfr.readLine();
            System.out.println("Received from server: " + message);


            bfr.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
