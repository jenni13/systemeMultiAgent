package systemeMultiAgent;


import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class Salle extends Environment{
    
	private CapteurLuminosite[] capteurLum;
    public SatisfationClient sc ;
    public Calendar heure = Calendar.getInstance(); 
    public Calendar heured = Calendar.getInstance();
    public Calendar heuref = Calendar.getInstance();
    
    public Salle() {
    	
        super(Scheduling.DEFAULT);
        sc = new SatisfationClient();
        ArrayList<Integer> n = new ArrayList<Integer>();
        sc.notes=sc.randNotes(n);
        sc.afficherNotes(n);
        sc.calculMoyenne(n);
        //this.heure.get(Calendar.HOUR_OF_DAY);
        this.heure.set(Calendar.HOUR,12);
        //this.heure.get(Calendar.MINUTE);
        this.heured.set(Calendar.HOUR,7);
        this.heuref.set(Calendar.HOUR,19);
    }
    @Override
    public void onInitialization() 
    {
        // Set 5 captors on the room
    	
        capteurLum = new CapteurLuminosite[5];
        for (int i = 0; i < capteurLum.length; i++)
            capteurLum[i] = new CapteurLuminosite();

    }

    public CapteurLuminosite[] getCapteurLum() 
    {
        return capteurLum;
    }
    
    public Calendar setHeure(Calendar heure,int n)  //simuler les heures qui passent dans une journée
    {
    	heure= Calendar.getInstance();
    	heure.get(Calendar.MINUTE);	
    	System.out.println("Heure: "+heure+"\n");

    	return heure;
    }

}
