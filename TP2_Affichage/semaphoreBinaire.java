package v2;

public final class semaphoreBinaire extends semaphore {
public semaphoreBinaire(int valeurInitiale){
	super((valeurInitiale != 0) ? 1:0);
	System.out.println("Je rentre en section critique : "+valeurInitiale);
}
public final synchronized void syncSignal(){
	super.syncSignal();
	System.out.println("Je sors de section critique : "+valeur);
	if (valeur>1) valeur = 1;
}
}

