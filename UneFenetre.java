import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UneFenetre extends JFrame implements ActionListener{
    UnMobile sonMobile;
    private final int LARG=400, HAUT=250;
    private Thread t;
    private JButton sonBouton1;
    private JButton sonBouton2;
    private boolean etat = true;
    
    public UneFenetre(){
    	super("Mobile");
    	
    	Container leConteneur = getContentPane();
    	leConteneur.setLayout (new GridLayout(1, 2));
    	
    	this.setSize(LARG,HAUT);
    	this.setVisible(true);
    	// ajouter sonMobile a la fenetre    
    	sonMobile = new UnMobile(LARG/2,HAUT);

    	sonBouton1= new JButton ("Start/Stop");
    	sonBouton1.addActionListener(this);
    	leConteneur.add(sonBouton1,BorderLayout.WEST);
    	leConteneur.add(sonMobile,BorderLayout.EAST);

    	
    	// creer une thread laThread avec sonMobile
    	t = new Thread(sonMobile);
    	// afficher la fenetre    	
    	// lancer laThread 
    	t.start();
    }

	@Override
	public void actionPerformed(ActionEvent parEvt) {
		if(parEvt.getActionCommand().equals("Start/Stop")){
			if (etat == true){
				etat = false;
				t.suspend();
			}
			else{
				etat = true;
				t.resume();
			}
		}
	}
}
