package v5;

import java.util.Scanner;

public class Productor extends Thread{

	private BAL mailbox;
	private String texte;

	public Productor(BAL b, String lettre) {
		mailbox=b;
	}
	
	public Productor(BAL b){
		mailbox=b;

	}

	public void run(){
		String str;
		try{
			while(true){
				Scanner sc = new Scanner(System.in);
				str = sc.nextLine();
				texte = str;
				
				Thread.sleep(1000) ;
	            boolean added = mailbox.depose(texte) ;
	
	            if (added) {
	              System.out.println("Je dépose :" + texte) ;
	           }  else {
	              System.out.println("la BAL est pleine.") ;
	           }
	        }

		}  
		catch (InterruptedException e) {
        System.out.println("Je m'arrête") ;
		}
	}
}

