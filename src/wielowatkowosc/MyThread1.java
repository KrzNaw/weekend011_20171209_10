package wielowatkowosc;

class MyThread1  implements Runnable{
    Thread thrd;

    MyThread1 (String name){
        thrd = new Thread(this, name); //thread uzyskuje nazwę w momencie utworzenia
        thrd.start();//uruchamia wątek
    }


    @Override
    public void run() {
        System.out.println(thrd.getName() + " rozpoczyna działanie.");
        try{
            for (int count=0; count<10; count++){
          Thread.sleep(400);
                System.out.println(thrd.getName() + " jest wykonywany, wartość licznika to: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " został przerwany.");
        }
        System.out.println(thrd.getName() + " kończy działanie.");
    }
}

class UseThreadsImproved{
    public static void main(String[] args) {
        System.out.println("Główny wątek zaczyna działanie.");

        MyThread1 mt = new MyThread1("Wątek potomny nr 1");//wątek zostaje uruchomiony w momencie utworzenia
        MyThread1 mt2 = new MyThread1("Wątek potomny nr 2");
        MyThread1 mt3 = new MyThread1("Wątek potowmny nr 3");

        for (int i =0; i<50; i++){
            System.out.println(".");
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("wątek główny został przerwany.");
            }
        }


        System.out.println("Wątek główny kończy działanie.");
    }
}
