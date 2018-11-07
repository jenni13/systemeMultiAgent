package systemeMultiAgent;
import java.util.Date;
import java.util.Random;
import fr.irit.smac.amak.Agent;
import fr.irit.smac.lxplot.LxPlot;
import fr.irit.smac.lxplot.commons.ChartType;

public class AgentLumiereIntelligente extends Agent<MyAMAS,Salle>{
	
    private CapteurLuminosite interieur;
    private CapteurLuminosite exterieur;
    private double luminositeIntension;
    private int id;

    public enum State {
        ETEINDRE ,ALLUMER
    }

    private State state = State.ETEINDRE;

    public AgentLumiereIntelligente(int id, MyAMAS amas, CapteurLuminosite interieur, CapteurLuminosite exterieur) {
        super(amas);
        this.id = id;
        this.interieur = interieur;
        this.exterieur = exterieur;
    }

    @Override
    protected void onPerceive() {
        // Nothing goes here as the perception of neighbors criticality is already made
        // by the framework
    }

    @SuppressWarnings("deprecation")
	@Override
    protected void onDecideAndAct() {
        State nextState = state;
        Date date = new Date();
        switch (state) {


                case ETEINDRE:
                    if (interieur.Valeur() > 15)
                    {
                        System.out.println(" Allumer la  Lumiere " + this.id );
                        break;
                    }
                    
                    if (date.getHours()== 13)
                    	
                    {
                    	  System.out.println(" Allumer la  Lumiere " + this.id + " à l'heure " +date.getHours());
                    	  this.state = nextState;
                          break;
                    }
                    
                    
                    
              case ALLUMER:
                    if (exterieur.Valeur() < 15)
                    {
                        System.out.println("fermer la lumiere " + this.id);
                        break;
                    }
                    
                    if (date.getHours()== 7)
                    
                    {
                    	System.out.println(" Eteindre la  Lumiere " + this.id + " +à l'heure " +date.getHours());
                    	 this.state = nextState;
                     
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

