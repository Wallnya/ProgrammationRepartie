package v4;

public class Consumer extends Thread{
	private BAL mailbox;
	public Consumer(BAL b) {
		mailbox=b;
	}

	public void run(){
		mailbox.retirer();
	}

}
