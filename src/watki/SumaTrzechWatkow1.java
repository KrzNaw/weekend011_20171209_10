package watki;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SumaTrzechWatkow1 {
    public static void main(String[] args) throws InterruptedException {

        MojeRunnableImpl impl1 = new MojeRunnableImpl();
        ObserwatorSumy obserwator = new ObserwatorSumy();
        impl1.dodajObserwatora(obserwator);//Obserwator - wzorzec projektowy
        Thread watek1 = new Thread(impl1);

        MojeRunnableImpl impl2 = new MojeRunnableImpl();
        impl2.dodajObserwatora(obserwator);
        Thread watek2 = new Thread(impl2);

        MojeRunnableImpl impl3 = new MojeRunnableImpl();
        impl3.dodajObserwatora(obserwator);

        Thread watek3 = new Thread(impl3);

        watek1.start();
        watek2.start();
        watek3.start();

        Thread.sleep(2000);
        System.out.println(obserwator.zwrocSume());

    }
}

interface MojeRunnable extends Runnable {
    int podajWygenerowana();
}

class MojeRunnableImpl implements Runnable, Obserwowany {

    private List<Obserwator> obserwatorzy = new ArrayList<>();

    @Override
    public void run() {
        Random random = new Random();
        int wygenerowana = random.nextInt(100);
        System.out.println(wygenerowana);
        powiadamiajObserwatorow(new Zdazenie(wygenerowana));
    }

    @Override
    public void dodajObserwatora(Obserwator o) {
        obserwatorzy.add(o);
    }

    @Override
    public void usunObserwatora(Obserwator o) {
        obserwatorzy.remove(o);
    }

    @Override
    public void powiadamiajObserwatorow(Zdazenie z) {
        obserwatorzy.stream().forEach(o -> o.obserwuj(z));
    }

}

class ObserwatorSumy extends Obserwator {
    private int suma = 0;

    @Override
    public synchronized void obserwuj(Zdazenie z) {
        suma += z.getWynik();
    }

    public int zwrocSume() {
        return suma;
    }

}