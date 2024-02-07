import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable {

    private Seat[][] seats;


    public Server() {
        this.seats = new Seat[10][10];
        fillSeats();
    }

    public void fillSeats() {
        int id = 1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                seats[i][j] = new Seat(id, i, j);
                id++;
            }
        }
    }

    public String printSeats() {
        String seats = "";
        ;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.seats[i][j].isBooked()) {
                    seats += "[X]";
                } else
                    seats += "[ ]";

            }
            seats += ";";
            System.out.println();
        }
        return seats;
    }

    public boolean bookSeat(int row, int column) {
        if (this.seats[row][column].isBooked()) {
            return false;
        } else {
            this.seats[row][column].setBooked(true);
            return true;
        }
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1999);
            while (true) {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("Welcome to the cinema! Here are the available seats: ");
                out.println(printSeats());


                // anwser from the client with the seat to book
                String seatsReservation = in.readLine();

                int row = Integer.parseInt(seatsReservation.split(";")[0]);
                int column = Integer.parseInt(seatsReservation.split(";")[1]);
                System.out.println("Confirmation received. Booking seats..." + seatsReservation);

                if (bookSeat(row, column)) {
                    out.println("Seat booked successfully!");
                } else {
                    out.println("Seat is already booked!");
                }


                in.close();
                out.close();
                clientSocket.close();
                System.out.println("Waiting to stablish a new connection..");


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
