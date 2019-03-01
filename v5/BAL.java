package v5;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BAL {
    private BlockingQueue<String> queue =  new ArrayBlockingQueue<String>(20) ;
	
    //On peut deposer une lettre, mais si la boite au lettre est vide
    //stoup
    public  boolean depose(String lettre)  throws InterruptedException {
        //On dépose une lettre et si au bout de 200 millisecondes,
    	//il n'y a pas de réaction, alors on stop.
    	return queue.offer(lettre,  200, TimeUnit.MILLISECONDS) ;
    }
    
    //On peut retirer des lettres mais s'il n'y a rien
    //c'est inutile
    public String retire()  throws InterruptedException {
        //On retire une lettre et si au bout de 200 millisecondes,
    	//il n'y a pas de réaction, alors on stop.
        return queue.poll(200, TimeUnit.MILLISECONDS) ;
    }
}
