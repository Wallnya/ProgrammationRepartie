package v3;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class UneFenetre extends JFrame implements ActionListener{

    private final int LARG=999, HAUT=500;
    
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
    		myMobile[i]=new UnMobile(LARG/3,HAUT/10);
    		//myButton[i]=new JButton ("Start/Stop");
    		//myButton[i].setActionCommand(Integer.toString((i)));
    		//myButton[i].addActionListener(this);
    		leConteneur.add(myMobile[i]);
    		//leConteneur.add(myButton[i]);
    		myThread[i] = new Thread(myMobile[i]);
    		myState[i]=true;
    	}
    	for (int j=0;j<10;j++){
    		myThread[j].start();
    	}
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
	}
}
