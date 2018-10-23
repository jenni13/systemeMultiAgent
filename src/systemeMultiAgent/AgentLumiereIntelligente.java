package systemeMultiAgent;
import java.util.Random;
import fr.irit.smac.amak.Agent;
import fr.irit.smac.lxplot.LxPlot;
import fr.irit.smac.lxplot.commons.ChartType;

public class AgentLumiereIntelligente extends Agent<MyAMAS,Salle>{
	
    private CapteurLuminosite left;
    private CapteurLuminosite right;
    private double hungerDuration;
    private double eatenPastas;
    private int id;

    public enum State {
        THINK, HUNGRY, EATING
    }

    private State state = State.THINK;

    public AgentLumiereIntelligente(int id, MyAMAS amas, CapteurLuminosite left, CapteurLuminosite right) {
        super(amas);
        this.id = id;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void onPerceive() {
        // Nothing goes here as the perception of neighbors criticality is already made
        // by the framework
    }

    @Override
    protected void onDecideAndAct() {
        State nextState = state;
        switch (state) {
        case EATING:
            eatenPastas++;
            if (new Random().nextInt(101) > 50) {
                left.release(this);
                right.release(this);
                nextState = State.THINK;
            }
            break;
        case HUNGRY:
            hungerDuration++;
            if (getMostCriticalNeighbor(true) == this) {
                if (left.tryTake(this) && right.tryTake(this))
                    nextState = State.EATING;
                else{
                    left.release(this);
                    right.release(this);
                }
            } else {
                left.release(this);
                right.release(this);
            }
            break;
        case THINK:
            if (new Random().nextInt(101) >50) {
                hungerDuration = 0;
                nextState = State.HUNGRY;
            }
            break;
        default:
            break;

        }

        state = nextState;
    }

    @Override
    protected double computeCriticality() {
        return hungerDuration;
    }

    @Override
    protected void onUpdateRender() {
        LxPlot.getChart("Eaten Pastas", ChartType.BAR).add(id, eatenPastas);
    }

}
