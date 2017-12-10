package salesChannel;

public class SalesChannel {
    private Product product;

    public void add(Product product) {
        this.product = product;
    }

    public Product get() {
        return product;
    }

    public static void main(String[] args) {
        SalesChannel salesChannel = new SalesChannel();
        Producer producer = new Producer(salesChannel);
        Consumer consumer = new Consumer(salesChannel);

    }

}


class Producer {
    private SalesChannel salesChannel;

    public Producer(SalesChannel salesChannel) {
        this.salesChannel = salesChannel;
    }

    void putProductIntoChannel(Product product) {
        salesChannel.add(product);
    }
}


class Consumer {
    private SalesChannel salesChannel;

    public Consumer(SalesChannel salesChannel) {
        this.salesChannel = salesChannel;
    }

    void buyProductFromChannel() {
        Product product = salesChannel.get();
    }

}


class Product {
    private String nazwa;

    public Product(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}