/*
package filozofowie;

public class Philosopher {


}

class PhilosopherThread extends Thread {

    private String name;

    public void run() {
        while (true) {
            isThinking();
            Fork fork = this.isForkAvailable(Philosopher.lookingForFork);
            if (fork.isForkAvailable(equals(true))) {
                fork.use(this);
                isEating(fork, Philosopher.availableForks);
            }

        }
    }

    public void isThinking() {
        System.out.println(name + " Myślę!");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isEating(boolean b) {
        System.out.println(name + "Teraz jem!");
        b = true;
        return b;
    }
}

class Fork {
    private PhilosopherThread philosopherThread;

    private String name;

    public Fork(String name) {
        this.name = name;
    }

    public void use(PhilosopherThread philosopherThread) {

    }

    public boolean isForkAvailable(PhilosopherThread philosopherThread) {
        while (philosopherThread.isEating(true)) {

        }
    }

}
*/
