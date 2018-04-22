import net.dv8tion.jda.client.entities.Group;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.exceptions.PermissionException;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import net.dv8tion.jda.core.*;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.*;
import javax.security.auth.login.LoginException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TimeZone;


/**
 * Beschreiben Sie hier die Klasse Bot.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Bot
{
    public FileCatcher FileHandler;
    public static TextChannel eliteTXChannel;
    public static TextChannel eliteTXGeneral;
    private static JDA jda;
    public static void main(String[] args) throws Exception
    {
        //load the Settings
        Config.load(STATIC.settingsPath);
        STATIC.discordToken = Config.getInstance().discordToken;
        STATIC.systemDBPath = Config.getInstance().systemDBPath;
        STATIC.systemDBFileUrl = Config.getInstance().systemDBFileURL;
        STATIC.autoUpdate = Config.getInstance().autoUpdate;
        STATIC.dailyUpdate = Config.getInstance().dailyUpdate;
        Config.getInstance().toFile(STATIC.settingsPath);
        //Timer for automated update message
        Timer timer = new Timer("EliteDailyFactionUpdate");
        Calendar date = Calendar.getInstance(TimeZone.getTimeZone("CET"));
        //make update time variable later
        date.set(Calendar.HOUR_OF_DAY, 21);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        Calendar date2 = Calendar.getInstance(TimeZone.getTimeZone("CET"));
        
        //the stuff that makes it go tick
        FileCatcher FileHandler = new FileCatcher();
        FileHandler.getStation(STATIC.systemDBPath, STATIC.systemDBFileUrl);
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        builder.setToken(STATIC.discordToken);
        builder.setAutoReconnect(true);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("Monitoring the Universe v. " + STATIC.VERSION));
        //builder.setGame(Game.playing("Under Construction"));
        System.out.println("Version:" + STATIC.VERSION);
        builder.addEventListener(new MyListener());
        try{
            JDA jda = builder.buildBlocking();
            eliteTXChannel = jda.getTextChannelById(STATIC.eliteChannelId);
            eliteTXGeneral = jda.getTextChannelById(STATIC.eliteGeneralId);
            
            //check if set date is before or after startup
            if(date.before(date2)){
                date.add(Calendar.DAY_OF_YEAR,1);
                new DailyUpdater();
            }
            timer.schedule(new DailyUpdater(), date.getTime(), 1000 * 60 * 60 * 24);
        }catch (LoginException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }/*catch(RateLimitedException e){
            e.printStackTrace();
        }*/
    }
    
    //bullshit static because fuck OOP sometimes
    public static TextChannel getEliteTXChannel(){
        return eliteTXChannel;
    }
    
    public static TextChannel getEliteTXGeneral(){
        return eliteTXGeneral;
    }
}
