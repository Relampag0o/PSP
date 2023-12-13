import java.util.concurrent.Semaphore;

public class Terminal {


    private String name;
    public Semaphore tracks;
    private int usages;
    private Boolean underMaintainance;

    public Terminal(String name) {
        this.name = name;
        tracks = new Semaphore(2);
        this.usages = 0;
        this.underMaintainance = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semaphore getTracks() {
        return tracks;
    }

    public void setTracks(Semaphore tracks) {
        this.tracks = tracks;
    }

    public int getUsages() {
        return usages;
    }

    public void setUsages(int usages) {
        this.usages = usages;
    }

    public Boolean getUnderMaintainance() {
        return underMaintainance;
    }

    public void setUnderMaintainance(Boolean underMaintainance) {
        this.underMaintainance = underMaintainance;
    }
}
