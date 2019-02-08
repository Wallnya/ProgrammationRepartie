package v2;

public abstract class semaphore {

    protected int valeur=0;

    protected semaphore (int valeurInitiale){
	valeur = valeurInitiale>0 ? valeurInitiale:0;
    }

    public synchronized void syncWait(){
	try {
	    while(valeur<=0){
		wait();
        }
	    valeur--;
	} catch(InterruptedException e){}
	System.out.println("Je rentre en section critique : "+valeur);
    }

    public synchronized void syncSignal(){
	if(++valeur > 0) notifyAll();
    }
}
