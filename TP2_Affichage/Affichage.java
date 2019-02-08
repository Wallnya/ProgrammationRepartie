package v2;

import java.lang.String;

public class Affichage extends Thread{
	String texte;
	static semaphoreBinaire mutex = new semaphoreBinaire(1);
	public Affichage (String txt){texte=txt;}
	
	public void run(){
			//Section critique, c'est le for
			mutex.syncWait();
			for (int i=0; i<texte.length(); i++){
			    System.out.print(texte.charAt(i));
			    try {sleep(100);} catch(InterruptedException e){};
			}//Fin
			mutex.syncSignal();
	}
}
