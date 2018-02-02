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
        this.dailyUpdate(Bot.getEliteTXChannel());
    }
    
    private void dailyUpdate(TextChannel pchannel){
        MessageChannel channel = pchannel;
        FileHandler.getStation(STATIC.path, STATIC.fileUrl);
        String updateMessage = FileHandler.getInfo(STATIC.path, STATIC.ourFaction);
        channel.sendMessage(updateMessage).queue();
    }
}
