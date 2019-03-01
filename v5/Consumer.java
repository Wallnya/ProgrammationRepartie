package v5;

public class Consumer extends Thread{
	private BAL mailbox;
	public Consumer(BAL b) {
		mailbox=b;
	}

	public void run(){

	      try {

	          while (true) {
	             // on dépose des lettres.
	            Thread.sleep(1000);
	            String texte = mailbox.retire() ;
	             if (texte != null) {
		              System.out.println("Je retire :" + texte) ;
	            }  else {
		              System.out.println("la BAL est vide.") ;
	            }
	         }

	      }  
	      catch (InterruptedException e) {
	         System.out.println("Je m'arrête") ;
	      }
	  }
}


