public class Book {
    private String name;
    private Boolean writerIsWriting;

    public Book(String name) {
        this.name = name;
        this.writerIsWriting = false;
    }

    public synchronized void read(String name) {

        while (writerIsWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(" " + name + " is reading");
        try {
            Thread.sleep(1000);
            System.out.println("Im done reading");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void write(String name) {

        while (writerIsWriting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        writerIsWriting = true;
        System.out.println(" " + name + " is writing");
        try {
            Thread.sleep(1000);
            System.out.println("Im done writing");
            writerIsWriting = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
