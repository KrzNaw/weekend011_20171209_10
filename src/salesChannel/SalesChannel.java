package salesChannel;

import java.util.ArrayList;
import java.util.List;

public class SalesChannel {
    private Product product;

    public void add(Product product) {
        System.out.println("Add product: " + product);
        this.product = product;
    }

    public Product get() {
        System.out.println("Get product: " + product);
        Product localProduct = product;
        product = null;
        return localProduct;
    }

    public boolean isBusy() {
        return product != null;
    }

    public static void main(String[] args) throws InterruptedException {
        SalesChannel salesChannel = new SalesChannel();
        List<Product> products = new ArrayList<>();
        Producer producer = new Producer(salesChannel, products);
        Consumer consumer = new Consumer(salesChannel);


        products.add(new Product("Vodka"));
        products.add(new Product("Beer"));
        products.add(new Product("Herring"));
        products.add(new Product("Pickle"));
        products.add(new Product("Scotch"));
        products.add(new Product("Cognac"));

        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();


        while (shouldContinue(products.size(), consumer.getAmountOfBought())) {
            Thread.sleep(1000);
        }

        System.out.println("- - - - - -");
        consumerThread.interrupt();

    }

    private static boolean shouldContinue(int size, int amountOfBought) {
        if (size == amountOfBought) {
            return false;
        }
        return true;
    }

}


class Producer implements Runnable {
    private SalesChannel salesChannel;
    private List<Product> products;
    private int amountOfSold;

    public Producer() {
    }

    public Producer(SalesChannel salesChannel, List<Product> products) {
        this.salesChannel = salesChannel;
        this.products = products;
    }

    void putProductIntoChannel(Product product) {
        while (true) {
            if (!salesChannel.isBusy()) {
                salesChannel.add(product);
                amountOfSold++;
                break;
            }
        }
    }

    @Override
    public void run() {
        for (Product product : products) {
            System.out.println("Selling product: " + product);
            this.putProductIntoChannel(product);
        }
    }

    @Deprecated
    int getAmountOfSold() {
        return amountOfSold;
    }

}


class Consumer implements Runnable {
    private SalesChannel salesChannel;
    private int amountOfBought;

    public Consumer(SalesChannel salesChannel) {
        this.salesChannel = salesChannel;
    }

    public int getAmountOfBought() {
        return amountOfBought;
    }

    void buy() {
        while (true) {
            if (salesChannel.isBusy()) {
                Product product = salesChannel.get();
                amountOfBought++;
                System.out.println("Product bought: " + product);
            }
        }
    }

    @Override
    public void run() {
        buy();
    }

}


class Product {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    class InterruptedThread extends Thread {

        @Override
        public void interrupt() {
            super.interrupt();
        }
    }

}