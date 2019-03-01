package v5;

public class Consumer extends Thread{
	private BAL mailbox;
	
	public Consumer(BAL b) {
		mailbox=b;
	}

	public void run(){
	      try {
	          while (true) {
		            // on retire une lettres au bout d'une seconde
		            Thread.sleep(1000);
		            String texte = mailbox.retire() ;
		            //Si on peut retirer une lettre
		            //donc que le texte n'est pas vide
		            if (texte != null) {
		            	//on la retire et on prévient
			            System.out.println("Je retire :" + texte) ;
		            }  
		            else {
		            	 //Sinon on prévient que la boite au lettre est vide
			              System.out.println("la BAL est vide.") ;
		            }
	          }//fin while

	      }//fin try  
	      catch (InterruptedException e) {
	         System.out.println("Je m'arrête") ;
	      }//fin catch
	}//run()
}//Consumer


