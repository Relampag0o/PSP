import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private File files;
    private File usersCredentials;


    public Server() {
        this.files = new File("C:\\Users\\josem\\Desktop\\files");
        files.mkdir();
        this.usersCredentials = new File("usersCredentials.txt");
    }

    public Boolean checkUser(String username, String password) {
        try {
            BufferedReader bfr = new BufferedReader(new FileReader(usersCredentials));
            String line = "";
            while ((line = bfr.readLine()) != null) {
                if (line.split(";")[0].equalsIgnoreCase(username) && line.split(";")[1].equals(password)) {
                    System.out.println("User found");
                    return true;
                }
            }
            System.out.println("User not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private void receiveFile(Socket clientSocket, String filename) throws IOException {
        InputStream inputStream = clientSocket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(files, filename + ".txt"));
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, bytesRead);
        }
        fileOutputStream.close();
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
                String message = in.readLine();
                System.out.println("Credentials received. Validating... " + message);
                if (checkUser(message.split(";")[0], message.split(";")[1])) {
                    out.println("APPROVED");
                    receiveFile(clientSocket, message.split(";")[0]);
                    System.out.println("File received!");

                }


                in.close();
                out.close();
                clientSocket.close();
                Thread.sleep(2000);
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
