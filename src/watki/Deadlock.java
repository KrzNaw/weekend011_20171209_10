package watki;

/**
 * Wygenerowanie deadlock
 * <p>
 * Jak zmieni sie wynik dzialania gdy smienimy kolejnosc synchronizacji?
 *
 * @author michal.jedryszka
 */

public class Deadlock {

    public static void main(String[] args) {
        String zasobA = "a";
        String zasobB = "b";

       Thread watek1 = new Thread(() -> {
            synchronized (zasobA) {
                System.out.println("Watek 1 blokuje A");
                try {
                    Thread.currentThread().sleep(1000);
                    synchronized (zasobB) {
                        System.out.println("Watek 1 blokuje B");
                        Thread.currentThread().sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        });

        Thread watek2 = new Thread(() -> {
            synchronized (zasobB) {
                System.out.println("Watek 2 blokuje B");
                try {
                    Thread.currentThread().sleep(1000);
                    synchronized (zasobA) {
                        System.out.println("Watek 2 blokuje A");
                        Thread.currentThread().sleep(1000);
                    }
                } catch (Exception e) {
                }
            }
        });
        watek1.start();
        watek2.start();

    }

}
