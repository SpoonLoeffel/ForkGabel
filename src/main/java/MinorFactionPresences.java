
/**
 * Write a description of class minor_faction_presences here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MinorFactionPresences
{
    // instance variables - replace the example below with your own
    private int minor_faction_id;
    private int state_id;
    private float influence;
    private String state;

    public int getMinorFactionId(){
        return minor_faction_id;
    }
    
    public void setMinorFactionId(int minor_faction_id){
        this.minor_faction_id = minor_faction_id;
    }
    
    public int getStateId(){
        return state_id;
    }
    
    public void setStateId(int state_id){
        this.state_id = state_id;
    }
    
    public float getInfluence(){
        return influence;
    }
    
    public void setInfluence(float influence){
        this.influence = influence;
    }
    
    public String getState(){
        return state;
    }
    
    public void setState(String state){
        this.state = state;
    }
}
