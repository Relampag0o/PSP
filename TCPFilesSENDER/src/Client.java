import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.sql.SQLOutput;

public class Client implements Runnable {


    private void sendFile(Socket socket, String filePath) throws IOException {
        File file = new File(filePath);
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
        OutputStream outputStream = socket.getOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        fileInputStream.close();
    }


    public void run() {

        try {
            Socket socket = new Socket("127.0.0.1", 1999);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer.write("pepe;qwerty1234");
                System.out.println("Data was sent to server");
                writer.newLine();
                writer.flush();


            String response = reader.readLine();
            System.out.println("Server response: " + response);
            if ("APPROVED".equals(response)) {
                sendFile(socket, "jose.txt");
                System.out.println("File sent!");
            } else {

                System.out.println("Access denied by the server.");
            }

                // closing
                writer.close();
                socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
