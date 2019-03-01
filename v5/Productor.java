package v5;

import java.util.Scanner;

public class Productor extends Thread{

	private BAL mailbox;
	private String texte;
	
	public Productor(BAL b){
		mailbox=b;
	}

	public void run(){
		String str;
		try{
			while(true){
				//Pour pouvoir écrire la lettre dans la terminale
				Scanner sc = new Scanner(System.in);
				str = sc.nextLine();
				texte = str;
				
				// toutes les secondes, le producteur
				//dépose une lettre
				Thread.sleep(1000) ;
	            boolean added = mailbox.depose(texte) ;
	
	            //Si on peut déposer une lettre
	            //on la dépose
	            if (added) {
	              System.out.println("Je dépose :" + texte) ;
	            }  
	            //Sinon on prévient que la boite au lettre est pleine
	            else {
	              System.out.println("la BAL est pleine.") ;
	           }
	            
	        }//fin while
		}//fin try 
		catch (InterruptedException e) {
			System.out.println("Je m'arrête") ;
		}//fin catch
	}//run()
}//Productor

