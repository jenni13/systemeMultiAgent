package systemeMultiAgent;
import java.util.Random;
import fr.irit.smac.amak.Agent;
import fr.irit.smac.lxplot.LxPlot;
import fr.irit.smac.lxplot.commons.ChartType;

public class AgentLumiereIntelligente extends Agent<MyAMAS,Salle>{
	
    private CapteurLuminosite interieur;
    private CapteurLuminosite exterieur;
    private SatisfationClient s;
    private int id;

    public enum State {
        ETEINDRE ,ALLUMER
    }

    private State state = State.ETEINDRE;

    public AgentLumiereIntelligente(int id, MyAMAS amas, CapteurLuminosite interieur, CapteurLuminosite exterieur,SatisfationClient s) {
        super(amas);
        this.id = id;
        this.interieur = interieur;
        this.exterieur = exterieur;
        this.s=s;
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


                case ETEINDRE:
                    if (interieur.Valeur() > 15)
                    {
                        System.out.println(" Allumer la  Lumiere " + this.id);
                        break;
                    }
        			if(s.getMoyenne()<5)
        			{
        				
        				System.out.println("Mauvaise satisfaction "+ this.id);
        				s.addNote();
        				s.removeNote();
        				s.afficherNotes(s.getNote());
        				s.calculMoyenne(s.getNote());
        				break;
        			}
        			else if(s.getMoyenne()>=5)
        			{
        				System.out.println("Bonne satisfaction "+ this.id);
        				
        				s.addNote();
        				s.removeNote();
        				s.afficherNotes(s.getNote());
        				s.calculMoyenne(s.getNote());
        				s.getMoyenne();
        				break;
        			}
            case ALLUMER:
                    if (exterieur.Valeur() < 15)
                    {
                        System.out.println("fermer la lumiere " + this.id);
                        break;
                    }
        			if(s.getMoyenne()<5)
        			{
        				
        				System.out.println("Mauvaise satisfaction "+ this.id);
        				s.addNote();
        				s.removeNote();
        				s.afficherNotes(s.getNote());
        				s.calculMoyenne(s.getNote());
        				break;
        			}
        			else if(s.getMoyenne()>=5)
        			{
        				System.out.println("Bonne satisfaction "+ this.id);
        				
        				s.addNote();
        				s.removeNote();
        				s.afficherNotes(s.getNote());
        				s.calculMoyenne(s.getNote());
        				s.getMoyenne();
        				break;
        			}
                    

                    default:
                    	break;
            }

        state = nextState;

    }

    protected double luminositeIntension(int luminositeIntension) {
        exterieur.Valeur();
        return luminositeIntension;
    }

    @Override
    protected void onUpdateRender() {
        LxPlot.getChart("luminositeIntension", ChartType.BAR).add(id,exterieur.Valeur() );
    }}

