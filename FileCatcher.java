import org.apache.commons.io.*;
import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

/**
 * Write a description of class FileCatcher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileCatcher{
    private String token;
    
    public FileCatcher(){
        token = this.getToken();
    }
    
    //check if it's the current JSON from EDDB
    public void getStation(String ppath, String pURL){
        if(STATIC.autoUpdate == true){
            File file = new File(ppath);
            if(file.exists()){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String lastmod = sdf.format(file.lastModified()) +"";
                String now = sdf.format(date) +"";
                if(lastmod.equals(now)){
                    //if(sdf.format(file.lastModified()) == sdf.format(date)){
                    // return;
                    
                }else{
                    //System.out.println("Last Modified: " + lastmod + "\n" + "Now:" + now);
                    this.updateDB(ppath, pURL);
                }
            }else{
                this.updateDB(ppath, pURL);   
            }
        }
    }
    
    //update EDDB JSON
    public void updateDB(String ppath, String pURL){
        File file = new File(ppath);
        try{
            FileUtils.copyURLToFile(new URL(pURL), file);
            System.out.println("downloading");
        }catch(Exception e){}
    }
    
    //Old reader copied from example. Not used. delete later.
    public static void readStream(String ppath, int pFactionId){
        boolean found = false;
        int factionId = pFactionId;
        try{
            InputStream stream = new FileInputStream(ppath);
            try {
                JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
                Gson gson = new GsonBuilder().create();
            
                // Read file in stream mode
                reader.beginArray();
                while (reader.hasNext()) {
                    // Read data into object model
                    StarSystems starSystem = gson.fromJson(reader, StarSystems.class);
                    //System.out.println(starSystem.getId() + starSystem.getName());
                    if(starSystem.getMinorFactions().contains("minor_faction_id="+factionId+".0")){
                        found = true;
                        //System.out.println(starSystem.getMinorFactions());
                        //System.out.println("System:" + starSystem.getName());
                    }
                    //break;
                }
                reader.close();
                if(found==false){
                   //System.out.println("Nothing found");
                }
            } catch (UnsupportedEncodingException ex) {
                System.out.println("readStream unsupportedEncodingException:");
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println("readStream IOException:");
                System.out.println(ex);
            }
        }catch(Exception e){
            System.out.println("Error Input Stream:" + e);
            return;
        }
    }
    
    
    //returns String with the Faction info message
    public String getInfo(String ppath,int pFactionId){
        boolean found = false;
        int factionId = pFactionId;
        String updateMessage ="Currently in Systems: \n";
        
        try{
            InputStream stream = new FileInputStream(ppath);
            try {
                JsonReader reader = new JsonReader(new InputStreamReader(stream, "UTF-8"));
                Gson gson = new GsonBuilder().create();
                
                // Read file in stream mode
                reader.beginArray();
                while (reader.hasNext()) {
                    // Read data into object model
                    StarSystems starSystem = gson.fromJson(reader, StarSystems.class);
                    //System.out.println(starSystem.getId() + starSystem.getName());
                    if(starSystem.getMinorFactions().contains("minor_faction_id="+factionId+".0")){
                        found = true;
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        Date date = new Date(starSystem.getUpdatedAt()*1000L);
                        String lastUpdated = sdf.format(date) +"";
                        updateMessage = updateMessage + starSystem.getName() + "; Economy: " + starSystem.getPrimaryEconomy() + "; System State: " + starSystem.getSysState()+ ";\n" 
                        + "Influence: " + starSystem.getFactionInfluence(factionId) + "%; "
                        + "Faction State: "+ starSystem.getFactionState(factionId) 
                        + "; Hold Controle: " + this.controlingFactionCheck(factionId, starSystem.getControllingMinorFactionId())
                        + "\n" + "Info Updated: " + lastUpdated + ";\n\n";
                        System.out.println("Systems:" + starSystem.getName());
                    }
                    //break;
                }
                reader.close();
                if(found==false){
                   System.out.println("Nothing found");
                }
            } catch (UnsupportedEncodingException ex) {
                System.out.println("readStream unsupportedEncodingException:");
                System.out.println(ex);
            } catch (IOException ex) {
                System.out.println("readStream IOException:");
                System.out.println(ex);
            }
        }catch(Exception e){
            System.out.println("Error Input Stream:" + e);
            return "ERROR! Please try again. If this keeps happening tell @SpoonLoeffel#5422";
        }
        return updateMessage;
    }
    
    
    //check if it's the controlling faction
    private String controlingFactionCheck(int pfactionId, int pcontrollingId){
        String factionId = pfactionId + "";
        String controllingId = pcontrollingId + "";
        if(controllingId.equals(factionId)){
            return "yes";
        }else{
            return "no";
        }
    }
    
    //get the token
    public String getToken(){
        
        if(token == null){
            String fileName = STATIC.tokenPath;
            String line = null;
            try{
                FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                
                while((line = bufferedReader.readLine())!=null){
                    token = line;
                }
                bufferedReader.close();
            }
            catch(FileNotFoundException ex) {
                System.out.println("Unable to open file '" + fileName + "'");                
            }
            catch(IOException ex) {
                System.out.println("Error reading file '" + fileName + "'");                  
                // Or we could just do this: 
                // ex.printStackTrace();
            }
        }
        return token;
    }
}
   

