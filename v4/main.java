package v4;


public class main {
    public static void main(String[] telsArgs) {
    	BAL b = new BAL();
		Consumer c = new Consumer(b);
		Consumer c2 = new Consumer(b);

		Productor p = new Productor(b,"coucou");
		Productor p2 = new Productor(b,"coucou2");


		c.start();
		c2.start();
		p.start();
		p2.start();
 	
    }
}
