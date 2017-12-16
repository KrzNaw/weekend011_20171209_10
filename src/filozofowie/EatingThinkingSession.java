package filozofowie;

import java.util.ArrayList;

public class EatingThinkingSession {
    static ArrayList<Fork> forks = new ArrayList<Fork>();
    static ArrayList<Philosopher02> philosopher02s = new ArrayList<Philosopher02>();
    static int numberOfPhilosophers = 5;
 
    public static void main(String[] args) throws InterruptedException {

    	for(int i = 0; i < numberOfPhilosophers; i++) {
    		forks.add(new Fork(i+1));
    	}
    	
    	for(int i = 0; i < numberOfPhilosophers; i++) {
        	int freeFork = i+1;
        	if(freeFork == numberOfPhilosophers) freeFork = 0;
        	
        	philosopher02s.add(new Philosopher02(i+1, forks.get(i), forks.get(freeFork)));
        }
       
        for (Philosopher02 f : philosopher02s) {
        	new Thread(f).start();
        	new Thread(() -> {
                try {
                    f.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


    }
}