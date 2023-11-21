public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer(100, 100);
        for (int i = 0; i < 3; i++) {
            Producer esc = new Producer("Escritor_" + i, b);
            Thread hiloEsc = new Thread(esc);
            hiloEsc.start();
        }

        for (int i = 0; i < 5; i++) {
            Consumer lec = new Consumer("Lector_" + i, b);
            Thread hiloLector = new Thread(lec);
            hiloLector.start();
        }


    }
}