import javax.swing.*;

public class UneFenetre extends JFrame {
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    
    public UneFenetre(){
    	super("Mobile");
    	this.setSize(LARG,HAUT);
    	this.setVisible(true);
    	// ajouter sonMobile a la fenetre    
    	sonMobile = new UnMobile(LARG,HAUT);
    	this.add(sonMobile);
    	// creer une thread laThread avec sonMobile
    	Thread t = new Thread(sonMobile);
    	// afficher la fenetre    	
    	// lancer laThread 
    	t.start();
    }
}
