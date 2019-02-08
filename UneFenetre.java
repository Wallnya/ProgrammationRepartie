import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UneFenetre extends JFrame implements ActionListener{
    UnMobile sonMobile;
    UnMobile sonMobile2;

    private final int LARG=800, HAUT=500;
    private Thread t;
    private Thread t2;
    private JButton sonBouton1;
    private JButton sonBouton2;
    private boolean etat = true;
    private boolean etat2 = true;
    
    private UnMobile[] myMobile;
    private Thread[] myThread;
    private JButton[] myButton;
    private boolean[] myState;
       
    public UneFenetre(){
    	super("Mobile");
    	
    	this.setSize(LARG,HAUT);
    	this.setVisible(true);
    	// ajouter sonMobile a la fenetre    

    	Container leConteneur = getContentPane();
    	leConteneur.setLayout (new GridLayout(10, 1));
    	
    	myMobile = new UnMobile[10];
    	myThread = new Thread[10];
    	myState = new boolean[10];
    	myButton = new JButton[10];
    	
    	
    	for (int i=0;i<10;i++){
    		myMobile[i]=new UnMobile(LARG,HAUT/10);
    		myButton[i]=new JButton ("Start/Stop");
    		myButton[i].setActionCommand(Integer.toString((i)));
    		myButton[i].addActionListener(this);
    		leConteneur.add(myMobile[i]);
    		leConteneur.add(myButton[i]);
    		myThread[i] = new Thread(myMobile[i]);
    		myState[i]=true;
    	}
    	for (int j=0;j<10;j++){
    		myThread[j].start();
    	}
    	/*sonMobile=new UnMobile(LARG/2, HAUT);
    	sonBouton1= new JButton ("Start/Stop");
    	sonBouton1.addActionListener(this);
    	leConteneur.add(sonBouton1);
    	leConteneur.add(sonMobile);
    	sonMobile2=new UnMobile(LARG/2, HAUT);
    	sonBouton2= new JButton ("Start/Stop");
    	sonBouton2.addActionListener(this);
    	leConteneur.add(sonBouton2);
    	leConteneur.add(sonMobile2);*/

    	
    	// creer une thread laThread avec sonMobile
    	/*t = new Thread(sonMobile);
    	t2 = new Thread(sonMobile2);*/
    	// afficher la fenetre    	
    	// lancer laThread 
    	/*t.start();
    	t2.start();*/
    }

	public void actionPerformed(ActionEvent parEvt) {
		Object source = parEvt.getSource();
		
		if (source instanceof JButton){
			int i = Integer.parseInt(parEvt.getActionCommand());
			if (myState[i] == true){
				myState[i] = false;
				myThread[i].suspend();
			}
			else{
				myState[i] = true;
				myThread[i].resume();
			}
		}
		/*if(source == sonBouton1){
			if (etat == true){
				etat = false;
				t.suspend();
			}
			else{
				etat = true;
				t.resume();
			}
		}
		if(source == sonBouton2){
			if (etat2 == true){
				etat2 = false;
				t2.suspend();
			}
			else{
				etat2 = true;
				t2.resume();
			}
		}*/
	}
}
