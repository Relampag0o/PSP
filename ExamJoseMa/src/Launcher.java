import java.io.*;
import java.util.LinkedList;


public class Launcher {

    public LinkedList<String> usernames;

    public Launcher() {
        this.usernames = new LinkedList<String>();
    }

    public void chargeData(String filename) {

        try {
            BufferedReader bfr = new BufferedReader(new FileReader(filename));
            String line = "";

            while ((line = bfr.readLine()) != null) {
                usernames.add(line);
            }
            System.out.println("Data successfullly added.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showUsernames() {
        for (String s : usernames) {
            System.out.println(s);
        }
    }

    public void launch(String dir, String occurrence) {
        File f = new File(dir);
        File[] files = f.listFiles();

        for (File fil : files) {
            try {
                if (fil.isDirectory()) {
                    launch(fil.getPath(), occurrence);
                } else {
                    ProcessBuilder pb = new ProcessBuilder("java", "Reader", fil.getAbsolutePath(), occurrence);
                    Process p = pb.start();
                    BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    try {
                        int exitcode = p.waitFor();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(bfr.readLine());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void createDirs(String dir) {
        ProcessBuilder pb = null;
        for (String s : usernames) {
            pb = new ProcessBuilder("java", "DirCreator", dir, s);
            try {
                Process p = pb.start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("---FOLDERS WERE SUCCESSFULLY CREATE.---");
        System.out.println("---CREATING ADMIN FOLDER---");

        pb = new ProcessBuilder("java", "DirCreator", dir, "admin");
        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Launcher l = new Launcher();
        l.launch(args[0], args[1]);
        l.chargeData(args[1]);
        l.showUsernames();
        l.createDirs(args[0]);



    }
}