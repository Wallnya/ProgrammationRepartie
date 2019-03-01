package v5v2;

import java.util.Scanner;

public class Productor extends Thread{

	private BAL mailbox;
	private String texte;
	
	public Productor(BAL b){
		mailbox=b;
	}

	public void run(){
		String str;
		Scanner sc = new Scanner(System.in);
		try{
			while(true){
				//Pour pouvoir �crire la lettre dans la terminale
				str = sc.nextLine();
				texte = str;
				
				// toutes les secondes, le producteur
				//d�pose une lettre
				Thread.sleep(1000) ;
	            mailbox.depose(texte) ;
	            if (texte.equals("*")){
					Thread.currentThread().interrupt();
	            }
	            else{
		            //Si on peut d�poser une lettre
		            //on la d�pose
		              System.out.println("Je d�pose :" + texte) ;            	
	            }             
	            
	        }//fin while
		}//fin try 
		catch (InterruptedException e) {
			System.out.println("Je m'arr�te") ;
		}//fin catch
	}//run()
}//Productor

