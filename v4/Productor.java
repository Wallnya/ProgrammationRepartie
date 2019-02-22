package v4;

public class Productor extends Thread{

	private BAL mailbox;
	private String texte;

	public Productor(BAL b, String lettre) {
		mailbox=b;
		texte=lettre;
	}

	public void run(){
		mailbox.deposer(texte);
	}
}
