public class Writer extends Thread {
    private String name;
    private Book book;


    public Writer(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                book.write(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
