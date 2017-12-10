package watki;
/**
 * 
Hello watki.
Napisz program ktory tworzy nastepujace watki.
Dziedziczacy po Thread.
Klase implementujaca Runnable
Anonimowa klase dziedziczaca po Thread
Anonimowa klase implementujaca runnable
Lambda
Kazdy watek w metodzie run wypisuje stringa opisujacego sposob utworzenia

 * @author mj
 *
 */
public class HelloWatki {
	
	public static void main(String[] args) {
		Thread poThread = new DziedziczePoThread();
		poThread.start();
	}

}

//Nie anonimowa klasa. Ma nazwe ktorej mozna uzyc z operatorem new
class DziedziczePoThread extends Thread{
	public void run(){
		System.out.println("Jestem watkiem dziedziczacym po Thread");
	}
}