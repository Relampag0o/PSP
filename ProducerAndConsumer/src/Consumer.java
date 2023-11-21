public class Consumer implements Runnable {
    private String name;
    private Buffer b;


    public Consumer(String name, Buffer b) {
        this.name = name;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Buffer getB() {
        return b;
    }

    public void setB(Buffer b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            b.consume(this.name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
