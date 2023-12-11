public class Reader extends Thread {
    private String name;
    private Book book;

    public Reader(String name, Book book) {
        this.name = name;
        this.book = book;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                book.read(name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
