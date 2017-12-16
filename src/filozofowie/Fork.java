package filozofowie;

public class Fork {
    private int fork;
    private boolean onTable;
    private int lastPhilosopher;

    public Fork(int fork) {
        this.fork = fork;
        onTable = true;
        lastPhilosopher = -1;
    }

    public boolean takeFork(int philosopher) {
        if(lastPhilosopher == philosopher) {
            return false;
        } else {
            if(onTable) {
                lastPhilosopher = philosopher;
                onTable = false;
                return true;
            } else {
                return false;
            }
        }
    }

    public void putBack() {
        onTable = true;
    }

    public int getFork() {
        return fork;
    }

    @Override
    public String toString() {
        return "Widelec{" +
                "widelec= " + fork +
                '}';
    }
}
