package v3;
import java.awt.*;

import javax.swing.*;

import v2.semaphore;

public class UnMobile extends JPanel implements Runnable{
    int saLargeur, saHauteur, sonDebDessin;
    final int sonPas = 10, sonTemps=50, sonCote=40;
    
    static semaphore sem = new semaphore(2) {};
    
    UnMobile(int telleLargeur, int telleHauteur){
	super();
	saLargeur = telleLargeur;
	saHauteur = telleHauteur;
	setSize(telleLargeur, telleHauteur);
    }

    public void run(){
	    while(true){
			for (sonDebDessin=0; sonDebDessin < saLargeur - sonPas; sonDebDessin+= sonPas){
				repaint();
				try{
					Thread.sleep(sonTemps);
				}
				catch (InterruptedException telleExcp){
					telleExcp.printStackTrace();
				}
			}
			sem.syncWait();
			for (sonDebDessin=saLargeur - sonPas;sonDebDessin < (saLargeur - sonPas)*2; sonDebDessin+= sonPas){
				repaint();
				try{
					Thread.sleep(sonTemps);
				}
				catch (InterruptedException telleExcp){
					telleExcp.printStackTrace();
				}
			}
			sem.syncSignal();
			for (sonDebDessin=(saLargeur - sonPas)*2;sonDebDessin < (saLargeur - sonPas)*3; sonDebDessin+= sonPas){
				repaint();
				try{
					Thread.sleep(sonTemps);
				}
				catch (InterruptedException telleExcp){
					telleExcp.printStackTrace();
				}
			}
			/*for (sonDebDessin= saLargeur - sonPas; sonDebDessin >0; sonDebDessin-= sonPas){
				repaint();
				try{
					Thread.sleep(sonTemps);
				}
				catch (InterruptedException telleExcp){
					telleExcp.printStackTrace();
				}
			}*/
	    }
    }

    public void paintComponent(Graphics telCG){
	super.paintComponent(telCG);
	telCG.fillRect(sonDebDessin, saHauteur/2, sonCote, sonCote);
    }
}