package systemeMultiAgent;

import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;
import java.util.*;



public class Salle extends Environment{
    private CapteurLuminosite[] capteurLum;
	private Date maDate;
	
    public Salle() {
        super(Scheduling.DEFAULT);
        this.maDate = new Date();
    }
    @Override
    public void onInitialization() {
        // Set 5 capteurs on the table
    	
        capteurLum = new CapteurLuminosite[5];
        for (int i = 0; i < capteurLum.length; i++)
            capteurLum[i] = new CapteurLuminosite();
    }

    public CapteurLuminosite[] getCapteurLum() {
        return capteurLum;
    }
}
