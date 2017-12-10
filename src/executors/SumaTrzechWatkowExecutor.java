package executors;

import watki.SumaTrzechWatkow;

import java.util.Random;
import java.util.concurrent.*;

public class SumaTrzechWatkowExecutor {

   private static Random random = new Random();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> num1 = es.submit(SumaTrzechWatkowExecutor::getNum);
        Future<Integer> num2 = es.submit(SumaTrzechWatkowExecutor::getNum);
        Future<Integer> num3 = es.submit(SumaTrzechWatkowExecutor::getNum);
        while (!num1.isDone() && !num2.isDone() && !num3.isDone()){}

        System.out.println(num1.get());
        System.out.println(num2.get());
        System.out.println(num3.get());
        int suma = num1.get() + num2.get() + num3.get();
        System.out.println("Suma: " + suma);

        es.shutdown();

    }

        public static Integer getNum() throws Exception {
            Thread.sleep((int) (Math.random() * 1000));
            return (random.nextInt(1000));
        }

}

