import java.io.File;
import java.io.IOException;

public class DirCreator {


    public void createDir(String path, String filename) {
        File f = new File(path + "\\" + filename);
        if (f.mkdir()) {
            String route = f.getPath() + "\\" + "welcome.txt";
            f = new File(route);
            try {
                if (f.createNewFile())
                    System.out.println("File successfully created.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        DirCreator dc = new DirCreator();
        dc.createDir(args[0], args[1]);

    }
}
