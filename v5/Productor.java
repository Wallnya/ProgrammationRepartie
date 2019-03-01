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
				//Pour pouvoir �crire la lettre dans la terminale
				Scanner sc = new Scanner(System.in);
				str = sc.nextLine();
				texte = str;
				
				// toutes les secondes, le producteur
				//d�pose une lettre
				Thread.sleep(1000) ;
	            boolean added = mailbox.depose(texte) ;
	
	            //Si on peut d�poser une lettre
	            //on la d�pose
	            if (added) {
	              System.out.println("Je d�pose :" + texte) ;
	            }  
	            //Sinon on pr�vient que la boite au lettre est pleine
	            else {
	              System.out.println("la BAL est pleine.") ;
	           }
	            
	        }//fin while
		}//fin try 
		catch (InterruptedException e) {
			System.out.println("Je m'arr�te") ;
		}//fin catch
	}//run()
}//Productor

