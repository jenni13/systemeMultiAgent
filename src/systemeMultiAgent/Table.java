package systemeMultiAgent;

import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

public class Table extends Environment{
    private Fork[] forks;
    public Table() {
        super(Scheduling.DEFAULT);
    }
    @Override
    public void onInitialization() {
        // Set 10 forks on the table
        forks = new Fork[10];
        for (int i = 0; i < forks.length; i++)
            forks[i] = new Fork();
    }

    public Fork[] getForks() {
        return forks;
    }
}
