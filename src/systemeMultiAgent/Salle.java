package systemeMultiAgent;

import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

public class Salle extends Environment{
    private CapteurLuminosite[] capteurLum;
    public Salle() {
        super(Scheduling.DEFAULT);
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
