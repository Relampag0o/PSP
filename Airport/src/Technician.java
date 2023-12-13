public class Technician implements Runnable {
    private String name;
    private Terminal terminal;

    public Technician(String name, Terminal terminal) {
        this.name = name;
        this.terminal = terminal;
    }


    @Override
    public void run() {
        while (true) {
            try {
                terminal.setUnderMaintainance(true);
                terminal.getTracks().acquire();
                System.out.println("I am the technician " + name + " and I am going to fix the terminal " + terminal.getName());
                Thread.sleep(5000);
                terminal.getTracks().release();
                terminal.setUnderMaintainance(false);
                System.out.println("I am the technician " + name + " and I have fixed the terminal " + terminal.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
