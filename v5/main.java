package v5;


public class main {
	
    public static void main(String[] telsArgs) {
    	BAL b = new BAL();
    	
		Consumer c = new Consumer(b);
		Productor p = new Productor(b);
		
		Thread [] producteurs = new Thread[1];
		Thread [] consommateurs = new Thread[1];
		
		//On prépare les threads du producteurs
		for (int i =0;i<producteurs.length;i++){
			producteurs[i]= new Thread(p);
		}
		//On prépare les threads du consommateurs
		for (int i =0;i<consommateurs.length;i++){
			consommateurs[i]= new Thread(c);
		}
		
		for (int i=0;i<producteurs.length;i++){
			producteurs[i].start();
		}
		
		for(int i=0;i<consommateurs.length;i++){
			consommateurs[i].start();
		}
    }
}
