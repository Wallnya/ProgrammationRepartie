package v6;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class Serveur implements Runnable{
   //On initialise des valeurs par défaut
   private int port = 550;
   private String host = "127.0.0.1";
   private ServerSocket server = null;
   private int numIt;
   private boolean isRunning = true;
   public Serveur(int pNumIte){
	   numIt = pNumIte;
      try {
         server = new ServerSocket(port, 100, InetAddress.getByName(host));
      } catch (UnknownHostException e) {
        e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }

   public Serveur(int pNum,String pHost, int pPort){
      host = pHost;
      port = pPort;
      numIt = pNum;
      try {
         server = new ServerSocket(port, 100, InetAddress.getByName(host));
      } catch (UnknownHostException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
   public void run(){
   	while(isRunning == true){
               try {
                  //On attend une connexion d'un client
                  Socket client = server.accept();               
                  //Une fois reçue, on la traite dans un thread séparé
                  System.out.println("Worker: Connexion cliente reçue.");                  
                  Thread t = new Thread(new ServeurProcessor(client));
                  t.start();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
            try {
               server.close();
            } catch (IOException e) {
               e.printStackTrace();
               server = null;
            }
   }

   public void close(){

      isRunning = false;

   }   

}
