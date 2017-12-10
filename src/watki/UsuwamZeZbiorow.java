package watki;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Napisz program który równoczeœnie wypisuje na ekran losowy element z nastêpuj¹cych zbiorów
 * Q, W, E, R, T, Y
 * 1, 2, 3, 4, 5, 6
 * ^, &, *, (, #
 * Wypisanie elementu usuwa go ze zbioru
 * Program koñczy dzia³anie gdy wszystkie elementy zostan¹ wypisane
 * <p>
 * W jaki inny sposób mozna przekazac referencje zbioru do watku?
 * W jaki inny sposob mozna zainicjalizowac zbiory?
 * Jak wyeliminowac zmienne i bloki statyczne?
 *
 * @author mj
 */
public class UsuwamZeZbiorow {
    //Instancja zbioru 1
    private static Set<String> zbior1 = new HashSet<>();
    private static Set<Integer> zbior2 = new HashSet<>();
    private static Set<Character> zbior3 = new HashSet<>();

    //Wypelnienie zbioru danymi
    static {
        zbior1.add("Q");
        zbior1.add("W");
        zbior1.add("E");
        zbior1.add("R");
        zbior1.add("T");
        zbior1.add("Y");
    }

    static {
        zbior2.add(1);
        zbior2.add(2);
        zbior2.add(3);
        zbior2.add(4);
        zbior2.add(5);
    }

    static {
        zbior3.add('^');
        zbior3.add('&');
        zbior3.add('*');
        zbior3.add('(');
        zbior3.add('#');
    }

    public static void main(String[] args) {
        //Watek dla zbioru
        Thread watekZbioru1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Pobieramy iterator
                Iterator<String> iterator1 = zbior1.iterator();
                //Dopoki iterator moze zwrocic element
                while (iterator1.hasNext()) {
                    //Pobierz i wypisz element
                    System.out.println(iterator1.next());
                    //Usun element
                    iterator1.remove();
                }
            }
        });
        //Wystartuj watek
        watekZbioru1.start();

        Thread watekZbioru2 = new Thread(() -> {

            Iterator<Integer> iterator2 = zbior2.iterator();
            while (iterator2.hasNext()) {
                System.out.println(iterator2.next());
                iterator2.remove();
            }
        });
        watekZbioru2.start();

        Thread watekZbioru3 = new Thread(() -> {

            Iterator<Character> iterator3 = zbior3.iterator();
            while ((iterator3.hasNext())) {
                System.out.println(iterator3.next());
                iterator3.remove();
            }
        });
watekZbioru3.start();


        try {
            watekZbioru1.join();
            watekZbioru2.join();
            watekZbioru3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("zbiorString isEmpty = "+ zbior1.isEmpty());
        System.out.println("zbiorInteger isEmpty = "+ zbior2.isEmpty());
        System.out.println("zbiorCharacter isEmpty = "+ zbior3.isEmpty());


    }

}