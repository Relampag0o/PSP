import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void run() {
        Scanner scnums = new Scanner(System.in);
        Scanner scstrs = new Scanner(System.in);

        try {
            Socket socket = new Socket("127.0.0.1", 1999);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // test. Ask which one should i use here, reader or out.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            String welcomeMessage = reader.readLine();
            System.out.println(welcomeMessage);
            String seatsData = reader.readLine();

            String[] rows = seatsData.split(";");

            for (String row : rows) {
                System.out.println(row);
            }


            System.out.println("Enter the row number you want to book: ");
            int row = scnums.nextInt();
            System.out.println("Enter the column number you want to book: ");
            int column = scnums.nextInt();

            System.out.println("You have selected seat: " + row + " " + column);
            System.out.println("Confirm booking? (y/n)");
            String confirm = scstrs.nextLine();

            if (confirm.equalsIgnoreCase("y")) {
                writer.write(row + ";" + column + "\n");
                out.println(row + ";" + column);
            } else {
                System.out.println("Booking cancelled.");
            }

            System.out.println(reader.readLine());



            writer.newLine();
            writer.flush();


            // closing
            writer.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
