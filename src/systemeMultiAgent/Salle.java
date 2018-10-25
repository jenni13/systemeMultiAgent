package systemeMultiAgent;

import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;
import java.util.*;
public class Salle extends Environment{
    private CapteurLuminosite[] capteurLum;
	
    public Salle()

    {
        super(Scheduling.DEFAULT);

    }
    @Override
    public void onInitialization() 
    {
        // Set 5 captors on the room

        capteurLum = new CapteurLuminosite[5];
        for (int i = 0; i < capteurLum.length; i++)

            capteurLum[i] = new CapteurLuminosite(); }

    public CapteurLuminosite[] getCapteurLum() 
    {
        return capteurLum;
    }
}
