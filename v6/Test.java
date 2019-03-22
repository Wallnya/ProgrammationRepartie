package v6;

public class Test {
	public static void main(String[] args) {
	    
	      String host = "127.0.0.1";
	      int port = 550;
	      Serveur []worker = new Serveur[20];
	      Thread []thread_worker = new Thread[20];
	      
	      MasterConnexion master = new MasterConnexion(host, port);
	      Thread threadMaster = new Thread(master);
	      threadMaster.start();
	      
	      
	      System.out.println("Serveur initialisé.");
	      
	      for(int i = 0; i < 1; i++){
	         worker[i] = new Serveur(10,"127.0.0.1",Integer.parseInt("550"+i));
	         thread_worker[i] = new Thread(worker[i]);
	         thread_worker[i].start();
	      }
	   }
}
