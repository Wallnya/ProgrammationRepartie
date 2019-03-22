package v6;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MasterConnexion implements Runnable{
	public long buffer[] = new long[20];
	   private Socket connexion = null;
	   private PrintWriter writer = null;
	   private BufferedInputStream reader = null;
	   
	   private static int count = 0;
	   private String name = "Worker-";
	   
	   public MasterConnexion(String host, int port){
		      name += ++count;
		      
		   }
		   
		   
		   public void run(){
		      //nous n'allons faire que 10 demandes par thread...
		      for(int i =0; i < 20; i++){
		         try {
		        	 
		            Thread.currentThread();
					Thread.sleep(1000);
		         } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		         try {
		        	 connexion = new Socket("127.0.0.1", Integer.parseInt("550"+i));
		        	writer = new PrintWriter(connexion.getOutputStream(), true);
		            reader = new BufferedInputStream(connexion.getInputStream());
		            
		            //On attend la réponse du worker
		            String response = read();
		            System.out.println("\t * " + name + " : Réponse reçue " + response);
		            buffer[i] = Long.parseLong(response);
		            
		         } catch (IOException e1) {
		            e1.printStackTrace();
		         }
		         
		         try {
		            Thread.currentThread().sleep(1000);
		         } catch (InterruptedException e) {
		            e.printStackTrace();
		         }
		      }
		      
		      writer.write("CLOSE");
		      writer.flush();
		      writer.close();
		   }
		   
		   
		   //Méthode pour lire les réponses du serveur
		   private String read() throws IOException{      
		      String response = "";
		      int stream;
		      byte[] b = new byte[4096];
		      stream = reader.read(b);
		      response = new String(b, 0, stream);      
		      return response;
		   }   
		}
