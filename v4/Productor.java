package v4;

import java.util.Scanner;

public class Productor extends Thread{

	private BAL mailbox;
	private String texte;

	public Productor(BAL b, String lettre) {
		mailbox=b;
	}
	
	public Productor(BAL b){
		mailbox=b;

	}

	public void run(){
		String str;
		while(true){
			Scanner sc = new Scanner(System.in);
			str = sc.nextLine();
			texte = str;
			mailbox.deposer(texte);

		}
	}
}
