package systemeMultiAgent;


import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;


import java.util.*;



public class Salle extends Environment{
    private CapteurLuminosite[] capteurLum;
    SatisfationClient sc ;
	
    public Salle() {
    	
        super(Scheduling.DEFAULT);
        sc = new SatisfationClient();
        ArrayList<Integer> n = new ArrayList<Integer>();
        sc.notes=sc.randNotes(n);
        sc.afficherNotes(n);
        sc.calculMoyenne(n);
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
    

}
