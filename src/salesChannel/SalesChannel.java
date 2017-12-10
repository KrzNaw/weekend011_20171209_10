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
        return product;
    }

    public boolean isBusy(){
        return products != null;
    }

    public static void main(String[] args) {
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

        producer.getAmountOfSold();
        consumer.getAmountOfBought();



    }

}


class Producer implements Runnable {
    private SalesChannel salesChannel;
    private List<Product> products;

    public Producer(){}

    public Producer(SalesChannel salesChannel, List<Product> products) {
        this.salesChannel = salesChannel;
        this.products = products;
    }

    void putProductIntoChannel(Product product) {
                salesChannel.add(product);
    }

    @Override
    public void run() {
        for(Product product : products){
            System.out.println("Selling product: " + product);
            this.putProductIntoChannel(product);}
    }

    int getAmountOfSold(){

    }
}


class Consumer implements Runnable {
    private SalesChannel salesChannel;

    public Consumer(SalesChannel salesChannel) {
        this.salesChannel = salesChannel;
    }

    void buyProductFromChannel() {
        if(salesChannel.isBusy()) {
            Product product = salesChannel.get();
            System.out.println("Product bought: " + product);
        }
    }

    @Override
    public void run() {
        buyProductFromChannel();
    }

    public int getAmountOfBought(){

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

        
}