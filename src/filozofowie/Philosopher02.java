package filozofowie;

public class Philosopher02 implements Runnable {
    private int philosopher;
    private Fork left;
    private Fork right;
    private int amountOfTimeEating;

    public Philosopher02(int philosopher, Fork left, Fork right) {
        this.philosopher = philosopher;
        this.left = left;
        this.right = right;
        amountOfTimeEating = 0;

        System.out.println("Philosopher02 " + this.philosopher + " bierze widelec " + this.left.getFork());
        System.out.println("Philosopher02 " + philosopher + " bierze widelec " + this.right.getFork());
    }

    public void run () {
        while(true) {
            boolean takeFork;


            System.out.println("Philosopher02 " + philosopher + " czeka na " + left.getFork());
            do {
                takeFork = left.takeFork(philosopher);
            } while(!takeFork);
            System.out.println("Philosopher02 " + philosopher + " bierze " + left.getFork());


            System.out.println("Philosopher02 " + philosopher + " czeka na " + right.getFork());
            do {
                takeFork = right.takeFork(philosopher);
            } while(!takeFork);
            System.out.println("Philosopher02 " + philosopher + " bierze " + right.getFork());


            System.out.println("Philosopher02 " + philosopher + " je");
            amountOfTimeEating++;
            System.out.println("przez ten " + amountOfTimeEating + " czas");


            System.out.println("Philosopher02 " + philosopher + " odklada widelec");
            left.putBack();
            right.putBack();


            System.out.println("Widelce lewy: " + left.toString() + " i prawy: " + right.toString() + " są wolne");
        }
    }
}