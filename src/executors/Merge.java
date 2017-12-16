package executors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Merge {
    public static void main(String[] args) {


//        List<Integer> list01 = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5}));
//        List<Integer> list02 = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5}));
//        List<Integer> list03 = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5}));
//        List<Integer> list04 = new ArrayList<>(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5}));
//
//
//        for (int i = 0; i < 6; i++) {
//            System.out.println("Lista 1.: " + list01);
//            Integer smallest = list01.get(0);
//            list01.remove(0);
//
//            System.out.println("Lista 2.: " + list02);
//            Integer smallest2 = list02.get(0);
//            list02.remove(0);
//
//            System.out.println("Lista 3.: " + list03);
//            Integer smallest3 = list03.get(0);
//            list03.remove(0);
//
//            System.out.println("Lista 4.: " + list04);
//            Integer smallest4 = list04.get(0);
//            list04.remove(0);
//
//            List<Integer> sortedList = new ArrayList<>(Arrays.asList(smallest, smallest2, smallest3, smallest4));
//
//            System.out.println("Posortowana: " + sortedList);
        //powyższy kod działa
        //}


        List<Integer> list01 = new ArrayList<>(Arrays.asList(new Integer[]{12, 22, 32, 42, 52}));
        List<Integer> list02 = new ArrayList<>(Arrays.asList(new Integer[]{10, 20, 30, 40, 50}));
        List<Integer> list03 = new ArrayList<>(Arrays.asList(new Integer[]{13, 23, 33, 43, 53}));
        List<Integer> list04 = new ArrayList<>(Arrays.asList(new Integer[]{11, 21, 31, 41, 51}));

        //List<Integer> mergedSortedList = new ArrayList<>();

        List<List<Integer>> mergedSortedList = new ArrayList<>();
        mergedSortedList.add(list01);
        mergedSortedList.add(list02);
        mergedSortedList.add(list03);
        mergedSortedList.add(list04);

     /*   for (int i = 0; i <5; i++) {

                int min = list01.get(0);
                int candidate = list01.get(i);

                if (min < candidate) {
                    mergedSortedList = Arrays.asList(new Integer[]{min});

                }
                list01.remove(min);
            }*/


     for (int i = 0; i < mergedSortedList.size(); i++){

     }

        System.out.println(mergedSortedList);

    }

    //TODO wynikime ma byc lista posortowana: Na ekranie powinno pojawić się 10, 11, 12, 13, 20, 21, 22, 23, 30, 31, 32, 33…...


  /*  public List<Integer> mergedSorting (List<Integer> toSort) {

        List<Integer> mergedSortedList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int min = (int) toSort.get(0);
            int candidate = (int) toSort.get(i);

            if (min < candidate) {
                mergedSortedList.add(min);
            }
        }
        return mergedSortedList;

    }*/

}



