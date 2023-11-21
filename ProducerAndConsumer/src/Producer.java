public class Producer implements Runnable {
    private String name;
    private Buffer b;


    public Producer(String name, Buffer b) {
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
            b.produce(this.name);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

