import java.io.*;
import java.net.URL;

public class Reader implements Runnable {

    private String fileURL;
    private String fileName;

    public Reader(String fileURL) {
        this.fileURL = fileURL;
        this.fileName = fileURL.split("/")[fileURL.split("/").length - 1];
    }

    @Override
    public void run() {

        try {
            URL url = new URL(fileURL);
            InputStream in = url.openStream();
            BufferedReader bfr = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bfw = new BufferedWriter(new FileWriter(fileName));
            String line;
            while ((line = bfr.readLine()) != null) {
                bfw.write(line + "\n");
            }

            bfr.close();
            bfw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
