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
                Thread.sleep(3000);
                terminal.getTracks().acquire();
                System.out.println("I am the technician " + name + " and I am going to fix the plane");
                terminal.setUnderMaintainance(true);
                Thread.sleep(3000);
                terminal.getTracks().release();
                terminal.setUnderMaintainance(false);
                System.out.println("I am the technician " + name + " and I have fixed the plane");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
