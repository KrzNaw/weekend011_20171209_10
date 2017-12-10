package executors;

/**
 * Zbiór wejściowy dzielimy na 4 części.
 * <p>
 * Każdą część sortujemy w oddzielnym wątku
 * <p>
 * Scalamy uzyskane wyniki: wybieramy pierwszy element z dowolnej części,
 * <p>
 * porównujemy z pozostałymi pierwszymi elementami w pozostałych częściach,
 * <p>
 * po znalezieniu najmniejszego/największego usuwamy go ze zbioru częściowego i
 * <p>
 * przepisujemy do zbioru wynikowego.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelSorter {

    public static void main(String[] args) {

        ParallelSorter parallelSorter = new ParallelSorter();
        List<Integer> testList = new ArrayList<>();

        for (int i = 0; i<24; i+=3){
            testList.add(i);
        }

        parallelSorter.partition(testList);
        parallelSorter.sort(testList);
        System.out.println(testList);


    }


    public List<Integer> sort(List<Integer> toSort) {
        //Podziel tablice wejsciowa na 4 czesci
        List<List<Integer>> partitions = partition(toSort);
        //Dla kazdej czesci z partycji utworz nowy watek z uzyciem executora
        //i callable
        ExecutorService ec = Executors.newFixedThreadPool(4);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> partition : partitions){
            Future<List<Integer>> submitOutcome = ec.submit(()->{
                Collections.sort(partition);
                return partition;
            });

            try {
                result.add(submitOutcome.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


        //posortuj w kazdym z watkow jedna czesc z partycji
        //posortowane czesci przypisz do tablicy tablic sortedPartitions
        List<List<Integer>> sortedPartitions = null;

        ec.shutdown();

        //Scal posortowane czesci
        return merge(sortedPartitions);

    }


    private List<Integer> merge(List<List<Integer>> sortedPartitions) {
        List<Integer> merged = new ArrayList<>();
        for(int i = 0; i<sortedPartitions.size(); i++){
            Integer smallest = sortedPartitions.get(i).get(0);
            if(smallest< i){

            }
        }


        return merged;
    }


    /**
     * Dzieli tablice wejsciowa na 4 elementowa tablice tablic
     *
     * @param toSort
     * @return
     */

    private List<List<Integer>> partition(List<Integer> toSort) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < toSort.size(); i++) {
            int reminder = i % 4;
            result.get(reminder).add(toSort.get(i));
        }
        System.out.println(result);
        return result;
    }

    public ParallelSorter() {
    }


}