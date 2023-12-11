// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Book book = new Book("Book");
        for (int i = 0; i < 5; i++) {
            new Reader("Reader" + i, book).start();
            new Writer("Writer" + i, book).start();

            
        }



    }
}