public class Reader implements Runnable {

    String msg;

    public Reader(String msg) {
        this.msg = msg;
    }


    @Override
    public void run() {
        System.out.println("Message Received: " + msg);
    }
}
