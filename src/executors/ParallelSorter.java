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
import java.util.List;
import java.util.Random;

public class ParallelSorter {



        public List<Integer> sort (List < Integer > toSort) {
            //Podziel tablice wejsciowa na 4 czesci
            List<List<Integer>> partitions = partition(toSort);
            //Dla kazdej czesci z partycji utworz nowy watek z uzyciem executora
            //i callable


            //posortuj w kazdym z watkow jedna czesc z partycji
            //posortowane czesci przypisz do tablicy tablic sortedPartitions
            List<List<Integer>> sortedPartitions = null;


            //Scal posortowane czesci
            return merge(sortedPartitions);
        }


        private List<Integer> merge (List < List < Integer >> sortedPartitions) {
            return ;
        }


        /**
         * Dzieli tablice wejsciowa na 4 elementowa tablice tablic
         * @param toSort
         * @return
         */

        private List<List<Integer>> partition (List < Integer > toSort) {
            return ;
        }

    }
