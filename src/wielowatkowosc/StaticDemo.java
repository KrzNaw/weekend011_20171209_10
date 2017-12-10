package wielowatkowosc;

class StaticMeth {
    static int val =1024;

    static int valDiv2(){
        return val/2;
    }
}

class SDemo2{
    public static void main(String[] args) {
        System.out.println("Wartość skłądowej val: " + StaticMeth.val);
        System.out.println("StaticMeth.valDiv2(): " + StaticMeth.valDiv2());

        StaticMeth.val = 4;
        System.out.println("Wartość skłądowej val: " + StaticMeth.val);
        System.out.println("StaticMeth.valDiv2(): " + StaticMeth.valDiv2());
    }
}
