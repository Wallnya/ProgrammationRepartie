package v5;


public class main {
	
    public static void main(String[] telsArgs) {
    	
    	//On crée une boite au lettre
    	BAL b = new BAL();
    	
    	
    	//On crée un objet de type consommateur et un objet
    	//de type producteur
		Consumer c = new Consumer(b);
		Productor p = new Productor(b);
		
		//Puis la création des threads
		Thread [] producteurs = new Thread[5];
		Thread [] consommateurs = new Thread[2];
		
		//On prépare les threads du producteurs
		for (int i =0;i<producteurs.length;i++){
			producteurs[i]= new Thread(p);
		}
		//On prépare les threads du consommateurs
		for (int i =0;i<consommateurs.length;i++){
			consommateurs[i]= new Thread(c);
		}
		
		//On lance pour chaque producteur
		for (int i=0;i<producteurs.length;i++){
			producteurs[i].start();
		}
		//On lance pour chaque consommateur
		for(int i=0;i<consommateurs.length;i++){
			consommateurs[i].start();
		}
    }
}
