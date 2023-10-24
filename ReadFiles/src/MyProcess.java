import java.io.*;

public class MyProcess {

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int counter = 0;
                File f = new File(args[0]);
                BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
                BufferedWriter bfw = new BufferedWriter(new FileWriter("C:\\Users\\Jose\\Downloads\\" + "sumado" + f.getName()));

                String line = "";
                Thread.sleep(1000);
                while ((line = bfr.readLine()) != null) {
                    counter += Integer.parseInt(line);

                }
                //System.out.println(counter);
                bfw.write(counter + "");
                bfr.close();
                bfw.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

