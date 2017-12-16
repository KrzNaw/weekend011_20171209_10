package niezmienne;

import java.util.HashSet;
import java.util.Set;

public class Niezmiennik {
    private final String nazwa;
    private final Set<CzescNiezmiennika> czesci;

    public Niezmiennik(String nazwa, Set<CzescNiezmiennika> czesci){
        this.nazwa = nazwa;
        this.czesci = new HashSet<CzescNiezmiennika>(czesci);
    }

    String getNazwa(){
        return nazwa;
    }

    Set<CzescNiezmiennika> getCzesci(){
        return new HashSet<CzescNiezmiennika>(czesci);
    }


    public static void main(String[] args) {
        Set set = new HashSet<CzescNiezmiennika>();
        Niezmiennik n = new Niezmiennik("a", set);
        set.add(new CzescNiezmiennika("c"));
        n.getCzesci().add(new CzescNiezmiennika("d"));
    }
}

class CzescNiezmiennika {
    String nazwaCzesci;

    CzescNiezmiennika(String nazwa) {
        this.nazwaCzesci = nazwa;
    }
}
