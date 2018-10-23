package systemeMultiAgent;

public class CapteurLuminosite {

    private AgentLumiereIntelligente takenBy;

    public synchronized boolean tryTake(AgentLumiereIntelligente asker) {
        if (takenBy != null)
            return false;
        takenBy = asker;
        return true;
    }

    public synchronized void release(AgentLumiereIntelligente asker) {
        if (takenBy == asker) {
            takenBy = null;
        }
    }

    public synchronized boolean owned(AgentLumiereIntelligente asker) {
        return takenBy == asker;
    }


}
