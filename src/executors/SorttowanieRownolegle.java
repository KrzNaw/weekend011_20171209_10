package executors;

import java.util.Arrays;

public class SorttowanieRownolegle {

    public static void main(String[] args) {

        Double[] chaos = new Double[10000000];
        Double[] chaosKopia = new Double[10000000];

        for (int i = 0; i < chaos.length; i++) {
            chaos[i] = random(i, chaos.length);
            chaosKopia[i] = chaos[i];
        }

        long start = System.currentTimeMillis();
        Arrays.sort(chaos);
        long end = System.currentTimeMillis();

        System.out.println("Czas normalnie: " + (end - start) + " ms.");

        start = System.currentTimeMillis();
        Arrays.parallelSort(chaosKopia);
        end = System.currentTimeMillis();

        System.out.println("Czas wielo-watkowo: " + (end - start) + " ms.");
    }

    private static Double random(int i, int length) {
        return Math.random() * i % length;
    }
}
