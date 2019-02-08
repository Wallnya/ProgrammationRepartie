package v2;

import java.lang.String;

public class Affichage extends Thread{
	String texte;
	static Exclusion exclusionIm = new Exclusion();
	public Affichage (String txt){texte=txt;}
	
	public void run(){

		//Section critique, c'est le for
		synchronized(exclusionIm){
			for (int i=0; i<texte.length(); i++){
			    System.out.print(texte.charAt(i));
			    try {sleep(100);} catch(InterruptedException e){};
			}//Fin
		}
	}
}
