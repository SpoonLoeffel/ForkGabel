import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.JDA;
import java.util.TimerTask;
/**
 * Write a description of class DailyUpdater here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DailyUpdater extends TimerTask
{
    // instance variables - replace the example below with your own
    FileCatcher FileHandler = new FileCatcher();
    public void run(){
        FileHandler.updateDB(STATIC.path, STATIC.fileUrl);
        this.dailyUpdate(Bot.getEliteTXChannel());
        try{
            Thread.sleep(100);
        }catch(Exception e){}
        this.dailyUpdate(Bot.getEliteTXGeneral());
        System.out.println("daily update");
    }
    
    private void dailyUpdate(TextChannel pchannel){
        if(STATIC.dailyUpdate == true){
            MessageChannel channel = pchannel;
            System.out.println("send message" + pchannel);
            // FileHandler.updateDB(STATIC.path, STATIC.fileUrl);
            String updateMessage = "Daily Faction Update:\n" + FileHandler.getInfo(STATIC.path, STATIC.ourFaction);
            channel.sendMessage(updateMessage).queue();
        }
    }
}
