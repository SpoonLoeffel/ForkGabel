import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import org.apache.commons.io.*;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Write a description of class StarSystems here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StarSystems
{
    // instance variables - replace the example below with your own
    private int id;
    private int edsm_id;
    private String name;
    private float x;
    private float y;
    private float z;
    private long population;
    private boolean is_populated;
    private int government_id;
    private String government;
    private int allegiance_id;
    private String allegiance;
    private int state_id;
    private String state;
    private int security_id;
    private String security;
    private int primary_economy_id;
    private String primary_economy;
    private String power;
    private String power_state;
    private int power_state_id;
    private boolean needs_permit;
    private long updated_at;
    private String simbad_ref;
    private int controlling_minor_faction_id;
    private String controlling_minor_faction;
    private int reserve_type_id;
    private String reserve_type;
    private Object minor_faction_presences;
    
    // /**
     // * Constructor for objects of class StarSystems
     // */
    // public StarSystems(int pid,int pedsmid, String name, float pcordX, float pcordY, float pcordZ, long ppopulation, boolean pisPopulated, int psysGovId, String psysGoverment, int psysAllegianceId, String psysAllegiance, int psysStateId, String psysState, int psysSecurityId, String psysSecurity, int psysPrimaryEconomyId, String psysPrimaryEconomy, String psysPower, String psysPowerState, int psysPowerStateId, boolean psysNeedsPermit, long pinfoUpdatedAt, String psimbadRef, int pcontrollingMinorFactionId, String pcontrollingMinorFaction, int psysReserveTypeId, String psysReserveType, String[] pminorFactions){
        // // initialise instance variables
        // id = pid;
        // edsmId = pedsmid;
        // this.name = name;
        // cordX = pcordX;
        // cordY = pcordY;
        // cordZ = pcordZ;
        // population = ppopulation;
        // isPopulated = pisPopulated;
        // sysGovId = psysGovId;
        // sysGoverment = psysGoverment;
        // sysAllegianceId = psysAllegianceId;
        // sysAllegiance =  psysAllegiance;
        // sysStateId = psysStateId;
        // sysState = psysState;
        // sysSecurityId = psysSecurityId;
        // sysSecurity = psysSecurity;
        // sysPrimaryEconomyId = psysPrimaryEconomyId;
        // sysPrimaryEconomy = psysPrimaryEconomy;
        // sysPower = psysPower;
        // sysPowerState = psysPowerState;
        // sysPowerStateId = psysPowerStateId;
        // sysNeedsPermit = psysNeedsPermit;
        // infoUpdatedAt = pinfoUpdatedAt;
        // simbadRef = psimbadRef;
        // controllingMinorFactionId = pcontrollingMinorFactionId;
        // controllingMinorFaction = pcontrollingMinorFaction;
        // sysReserveTypeId = psysReserveTypeId;
        // sysReserveType = psysReserveType;
        // //String[] pminorFactions;
    // }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getEDSMId(){
        return edsm_id;
    }
    
    public void setEDSMId(int edsm_id){
        this.edsm_id = edsm_id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
        
    public float getCordX(){
        return x;
    }
    
    public void setCordX(float x){
        this.x = x;
    }
            
    public float getCordY(){
        return y;
    }
    
    public void setCordY(float y){
        this.y = y;
    }
        
    public float getCordZ(){
        return z;
    }
    
    public void setCordZ(float z){
        this.z = z;
    }

    public long getPopulation(){
        return population;
    }
    
    public void setPopulation(long population){
        this.population = population;
    }
    
    public boolean getIsPopulated(){
        return is_populated;
    }
    
    public void setIsPopulated(boolean is_populated){
        this.is_populated = is_populated;
    }
    
    public int getsysGovId(){
        return government_id;
    }
    
    public void setSysGovId(int government_id){
        this.government_id = government_id;
    }
    
    public String getSysGovernment(){
        return government;
    }
    
    public void setSysGovernment(String government){
        this.government = government;
    }
    
    public int getSysAllegianceId(){
        return allegiance_id;
    }
    
    public void setSysAllegianceId(int allegiance_id){
        this.allegiance_id = allegiance_id;
    }
    
    public String getSysAllegiance(){
        return allegiance;
    }
    
    public void setSysAllegiance(String allegiance){
        this.allegiance = allegiance;
    }

    public int getSysStateId(){
        return state_id;
    }
    
    public void setSysStateId(int state_id){
        this.state_id =state_id;
    }
    
    public String getSysState(){
        return state;
    }
    
    public void setSysState(String state){
        this.state = state;
    }
    
    public int getSysSecurityId(){
        return security_id;
    }
    
    public void setSysSecurityId(int security_id){
        this.security_id = security_id;
    }
    
    public String getSysSecurity(){
        return security;
    }
        
    public int getSysPrimaryEconomyId(){
        return primary_economy_id;
    }
    
    public void setSysPrimaryEconomyId(int primary_economy_id){
        this.primary_economy_id = primary_economy_id;
    }
    
    public String getPrimaryEconomy(){
        return primary_economy;
    }
    
    public void setPrimaryEconomy(String primary_economy){
        this.primary_economy = primary_economy;
    }
        
    public String getSysPower(){
        return power;
    }
    
    public void setSysPower(String power){
        this.power = power;
    }
        
    public String getSysPowerState(){
        return power_state;
    }
    
    public void setSysPowerState(String power_state){
        this.power_state = power_state;
    }
            
    public int getSysPowerStateId(){
        return power_state_id;
    }
    
    public void setSysPowerStateId(int power_state_id){
        this.power_state_id = power_state_id;
    }
    
    public boolean getNeedsPermit(){
        return needs_permit;
    }
    
    public void setNeedsPermit(boolean needs_permit){
        this.needs_permit = needs_permit;
    }
    
    public long getUpdatedAt(){
        return updated_at;
    }
    
    public void setUpdatedAt(long updated_at){
        this.updated_at = updated_at;
    }
    
    public String getSimbadRef(){
        return simbad_ref;
    }
    
    public void setSimbadRef(String simbad_ref){
        this.simbad_ref = simbad_ref;
    }
                
    public int getControllingMinorFactionId(){
        return controlling_minor_faction_id;
    }
    
    public void setControllingMinorFactionId(int controlling_minor_faction_id){
        this.controlling_minor_faction_id = controlling_minor_faction_id;
    }
        
    public String getControllingMinorFaction(){
        return controlling_minor_faction;
    }
    
    public void setControllingMinorFaction(String controlling_minor_faction){
        this.controlling_minor_faction = controlling_minor_faction;
    }
                
    public int getReserveTypeId(){
        return reserve_type_id;
    }
    
    public void setReserveTypeId(int reserve_type_id){
        this.reserve_type_id = reserve_type_id;
    }
        
    public String getReserveType(){
        return reserve_type;
    }
    
    public void setReserveType(String reserve_type){
        this.reserve_type = reserve_type;
    }
    
    public Object getMinorFaction(){
        
        return minor_faction_presences;
        //return minor_faction_presences.class;
    }
    
    public void setMinorFaction(Object minor_faction_presences){
        this.minor_faction_presences = minor_faction_presences;
        System.out.println("" + minor_faction_presences);
        
    }
    
    public String getMinorFactions(){ 
        return minor_faction_presences + "";
        
    }
    
    public float getFactionInfluence(int pfactionId){
        float influence = 0;
        String factionId = pfactionId+"";
        boolean found = false;
        String pminorfaction = this.fixJson(this.getMinorFaction() + "");
        try{
            InputStream stream = IOUtils.toInputStream(pminorfaction, "UTF-8");
            try{
                JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
                Gson gson = new GsonBuilder().create();
                reader.setLenient(true);
                // Read file in stream mode
                reader.beginArray();
                while (reader.hasNext()) {
                    // Read data into object model
                    MinorFactionPresences minorFaction = gson.fromJson(reader, MinorFactionPresences.class);
                    if(factionId.contains(minorFaction.getMinorFactionId()+"")){
                        //System.out.println("getId:" + minorFaction.getMinorFactionId() + "; Id:" + factionId + " are equal");
                        found = true;
                        return minorFaction.getInfluence();
                    }else{
                        //System.out.println(pminorfaction + "getId:" + minorFaction.getMinorFactionId() + "; Id:" + factionId + " are not equal; " + minorFaction.getInfluence());
                    }
                }
                reader.close();
                if(found==false){
                    //System.out.println("Nothing found");
                }
            }catch(UnsupportedEncodingException ex) {
                System.out.println("readStream unsupportedEncodingException:");
                System.out.println(ex);
            }catch(IOException ex){
                System.out.println("readStream IOException:");
                System.out.println(ex);
            }
        }catch(Exception e){
            System.out.println("Error Input Stream:" + e);
            return 0;
        }
        return influence;
    }
    
        public String getFactionState(int pfactionId){
        String factionState = "";
        String factionId = pfactionId+"";
        boolean found = false;
        String pminorfaction = this.fixJson(this.getMinorFaction() + "");
        try{
            InputStream stream = IOUtils.toInputStream(pminorfaction, "UTF-8");
            try{
                JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
                Gson gson = new GsonBuilder().create();
                reader.setLenient(true);
                // Read file in stream mode
                reader.beginArray();
                while (reader.hasNext()) {
                    // Read data into object model
                    MinorFactionPresences minorFaction = gson.fromJson(reader, MinorFactionPresences.class);
                    //System.out.println(starSystem.getId() + starSystem.getName());
                    if(factionId.contains(minorFaction.getMinorFactionId()+"")){
                        //System.out.println("getId:" + minorFaction.getMinorFactionId() + "; Id:" + factionId + " are equal");
                        found = true;
                        return minorFaction.getState();
                    }else{
                        //System.out.println(pminorfaction + "getId:" + minorFaction.getMinorFactionId() + "; Id:" + factionId + " are not equal; " + minorFaction.getInfluence());
                    }
                }
                reader.close();
                if(found==false){
                    System.out.println("Nothing found");
                }
            }catch(UnsupportedEncodingException ex) {
                System.out.println("readStream unsupportedEncodingException:");
                System.out.println(ex);
            }catch(IOException ex){
                System.out.println("readStream IOException:");
                System.out.println(ex);
            }
        }catch(Exception e){
            System.out.println("Error Input Stream:" + e);
            return "";
        }
        return factionState;
    }
    
    
    //to fix the broken formatting of the minor factions string
    public String fixJson(String pJsonToFix){
        String JsonToFix = pJsonToFix;
        JsonToFix = JsonToFix.replaceAll("minor_faction_id", "\"minor_faction_id\"");
        JsonToFix = JsonToFix.replaceAll("state", "\"state\"");
        JsonToFix = JsonToFix.replaceAll("influence", "\"influence\"");
        JsonToFix = JsonToFix.replaceAll("\"state\"_id", "\"state_id\"");
        JsonToFix = JsonToFix.replace("=", ":");
        JsonToFix = JsonToFix.replace("Boom", "\"Boom\"");
        JsonToFix = JsonToFix.replace("Bust", "\"Bust\"");
        JsonToFix = JsonToFix.replace("Outbreak", "\"Outbreak\"");
        JsonToFix = JsonToFix.replace("Civil Unrest", "\"Civil Unrest\"");
        JsonToFix = JsonToFix.replace("War", "\"War\"");
        JsonToFix = JsonToFix.replace("Civil \"War\"", "\"Civil War\"");
        JsonToFix = JsonToFix.replace("Election", "\"Election\"");
        JsonToFix = JsonToFix.replace("Expansion", "\"Expansion\"");
        JsonToFix = JsonToFix.replace("Famine", "\"Famine\"");
        JsonToFix = JsonToFix.replace("Investment", "\"Investment\"");
        JsonToFix = JsonToFix.replace("Exiled", "\"Exiled\"");
        return JsonToFix;
    }
    
    
    
    
    
    
    /**++++++++++**/
    public String toString() {
        String minorFactions = "";
        // for(int i=0;minor_faction_presences.length;i++){
            // minorFactions=minorFactions +", " + minor_faction_presences[i];
        // }
        return "ID:" + id + " EDSMID:" + edsm_id + " Name:" + name + "X" + x + " Y" + y + " Z" + z + " population" + population + " ispopulated" + is_populated + "minor_faction_presences" + " " + minorFactions;
    }
}
