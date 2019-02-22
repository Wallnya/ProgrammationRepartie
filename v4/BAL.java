package v4;

public class BAL {
	private String buffer;
	private Boolean available;
	
	public BAL(){
		buffer = null;
		available = false;
	}
	
	public synchronized void deposer(String texte){
		//tant que c'est libre, attends
		while (available == true){
			try { wait();}
			catch (InterruptedException e){	}		
		}
		buffer = texte;
		System.out.println("Je depose cette lettre : "+buffer);
		available=true;
		notifyAll();
	}
	
	public synchronized void retirer(){
		//tant que c'est occupé, attends
		while (available == false){
			try { wait();}
			catch (InterruptedException e){	}
		}
		System.out.println("Je retire cette lettre : "+buffer);
		buffer = null;
		available=false;
		notifyAll();
	}
}
