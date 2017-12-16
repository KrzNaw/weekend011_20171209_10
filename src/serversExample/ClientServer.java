package serversExample;

import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ClientServer {

    public static void main(String[] args) {
        //Utworzyc watek serwera
        //utworzyc piec watkow klienckich
        //watki klienckie wysylaja zadania do serwera

        Server server = new Server();

        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();
        Client client5 = new Client();

        Thread t1 = new Thread(() -> {
            Connection c1 = client1.connect(server);
            Future<Response> response = c1.execute(new Request("qAz"));
            try {
                System.out.println(server.getCurrentRequest());
                System.out.println(response.get().getPayload());
                System.out.println(server.getCurrentRequest());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            Connection c2 = client2.connect(server);
            Future<Response> response = c2.execute(new Request("KrZySzToF"));
            try {
                System.out.println(server.getCurrentRequest());
                System.out.println(response.get().getPayload());
                System.out.println(server.getCurrentRequest());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            Connection c3 = client3.connect(server);
            Future<Response> response = c3.execute(new Request("katarzyna"));
            try {
                System.out.println(server.getCurrentRequest());
                System.out.println(response.get().getPayload());
                System.out.println(server.getCurrentRequest());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        t3.start();

        Thread t4 = new Thread(() -> {
            Connection c4 = client4.connect(server);
            Future<Response> response = c4.execute(new Request("STAS"));
            try {
                System.out.println(server.getCurrentRequest());
                System.out.println(response.get().getPayload());
                System.out.println(server.getCurrentRequest());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        t4.start();

        Thread t5 = new Thread(() -> {
            Connection c5 = client5.connect(server);
            Future<Response> response = c5.execute(new Request("PolUdnIowOafRykAnsKi"));
            try {
                System.out.println(server.getCurrentRequest());
                System.out.println(response.get().getPayload());
                System.out.println(server.getCurrentRequest());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        t5.start();



    }
}


class Client {

    Connection connect(Server server) {
        return new Connection(server);
    }

}

class Server {

    //pole watkow
    private ExecutorService threadPool = Executors.newFixedThreadPool(10);

    private int totalRequest = 0;
    //private int currentRequest = 0;
    //klasy atomowe
    private AtomicInteger currentRequest = new AtomicInteger(0);

    public Future<Response> service(Request request) {
        totalRequest++;
        currentRequest.incrementAndGet();
        //utworzyc watek z puli
        //wydelegowac tam obsługę zadania
        Future<Response> submitResult = threadPool.submit(() -> {
            String reversed = reverse(request.getPayload());
            String flipped = flip(reversed);
            currentRequest.decrementAndGet();
            return new Response(flipped);
        });
        return submitResult;
    }

    public int getCurrentRequest() {
        return currentRequest.intValue();
    }

    private String flip(String reversed) {
        char[] toChar = reversed.toCharArray();
        char[] flipedChar = new char[toChar.length];
        for (int i = 0; i < toChar.length; i++) {
            if (Character.isLowerCase(toChar[i])) {
                flipedChar[i] = Character.toUpperCase(toChar[i]);
            } else if (Character.isUpperCase(toChar[i])) {
                flipedChar[i] = Character.toLowerCase(toChar[i]);
            }
        }
        return new String(flipedChar);
    }

    private String reverse(String payload) {
        return new StringBuilder(payload).reverse().toString();
    }
}


class Connection {
    private Server server;

    public Connection(Server server) {
        this.server = server;
    }

    public Future<Response> execute(Request request) {
        return server.service(request);
    }
}

class Request {
    private String payload;

    public Request(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

}

class Response {
    private String payload;

    public Response(String payload) {
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

}