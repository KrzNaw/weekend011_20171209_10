package wielowatkowosc;

public class MyThread implements Runnable {

    String thrdName;

    MyThread(String name) {
        thrdName = name;
    }

    @Override
    public void run() {
        System.out.println(thrdName + " rozpoczyna działanie");
        try {
            for (int count = 0; count < 100; count++) {
                Thread.sleep(400);
                System.out.println(thrdName + " jest wykonywany, wartość licznika: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrdName + " został przerwany.");
            e.printStackTrace();
        }
    }

}

class UseThreads {
    public static void main(String[] args) {
        System.out.println("Główny wątek rozpoczyna działanie.");

        MyThread mt = new MyThread("Wątek potomny nr 1");//tworzy obiekt implementujjący Runnable
        Thread newThrd = new Thread(mt); //tworzy wątek dla tego obiektu

        newThrd.start();//uruchamia wątek

        for (int i = 0; i<90; i++){
            System.out.println(".");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Wątek główny został przerwany.");
            }
        }

        System.out.println("Wątek głóny kończy działanie.");
    }
}
