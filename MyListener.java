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
import net.dv8tion.jda.core.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.core.requests.Request;
import net.dv8tion.jda.core.requests.Response;
import net.dv8tion.jda.core.requests.RestAction;
import net.dv8tion.jda.core.requests.Route;
import net.dv8tion.jda.core.utils.Checks;
import net.dv8tion.jda.core.utils.MiscUtil;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import net.dv8tion.jda.core.entities.MessageHistory;
import javax.annotation.CheckReturnValue;
import java.util.*;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Random;
public class MyListener extends ListenerAdapter 
{   
    FileCatcher FileHandler = new FileCatcher();
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        Message message = event.getMessage();
        String content = message.getContentRaw();
        content = content.toLowerCase();
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            System.out.println("channel: " + channel);
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
        
        if(content.equals("!factioncheck"))
        {
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            FileHandler.getStation(STATIC.systemDBPath, STATIC.systemDBFileUrl);
            String updateMessage = FileHandler.getInfo(STATIC.systemDBPath, STATIC.ourFaction);
            channel.sendMessage(updateMessage).queue();
        }
        
        if(content.equals("!updatedb"))
        {
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                channel.sendMessage("refreshing database").queue();
                FileHandler.updateDB(STATIC.systemDBPath, STATIC.systemDBFileUrl);
            }
        }
        
        if(content.equals("!test"))
        {
            MessageChannel channel = event.getChannel();
            System.out.println(System.getProperty("java.vm.name") +"");
        }
        
        if(content.equals("!debug autoupdate on")){
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                STATIC.autoUpdate = true;
                Config.getInstance().autoUpdate = true;
                Config.getInstance().toFile(STATIC.settingsPath);
                System.out.println("autoUpdate: " + STATIC.autoUpdate);
                channel.sendMessage("autoUpdate: " + STATIC.autoUpdate).queue();
            }
        }
        
        if(content.equals("!debug autoupdate off")){
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                STATIC.autoUpdate = false;
                Config.getInstance().autoUpdate = false;
                Config.getInstance().toFile(STATIC.settingsPath);
                System.out.println("autoUpdate: " + STATIC.autoUpdate);
                channel.sendMessage("autoUpdate: " + STATIC.autoUpdate).queue();
            }
        }
        
        if(content.equals("!debug dailyupdate on")){
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                STATIC.dailyUpdate = true;
                Config.getInstance().dailyUpdate = true;
                Config.getInstance().toFile(STATIC.settingsPath);
                System.out.println("dailyUpdate: " + STATIC.dailyUpdate);
                channel.sendMessage("dailyUpdate: " + STATIC.dailyUpdate).queue();
            }
        }
        
        if(content.equals("!debug dailyupdate off")){
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                STATIC.dailyUpdate = false;
                Config.getInstance().dailyUpdate = false;
                Config.getInstance().toFile(STATIC.settingsPath);
                System.out.println("dailyUpdate: " + STATIC.dailyUpdate);
                channel.sendMessage("dailyUpdate: " + STATIC.dailyUpdate).queue();
            }
        }
        
        if(content.equals("!debugmode off")){
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                STATIC.dailyUpdate = true;
                STATIC.autoUpdate = true;
                Config.getInstance().autoUpdate = true;
                Config.getInstance().dailyUpdate = true;
                Config.getInstance().toFile(STATIC.settingsPath);
                System.out.println("Debugmode: " + STATIC.dailyUpdate);
                channel.sendMessage("Debugmode: " + STATIC.dailyUpdate).queue();
            }
        }

        if(content.equals("!debugmode on")){
            MessageChannel channel = event.getChannel();
            String pChannel = channel + "";
            String author = event.getAuthor()+"";
            if(author.equals("U:SpoonLoeffel(167343578857603072)")){
                STATIC.dailyUpdate = false;
                STATIC.autoUpdate = false;
                Config.getInstance().autoUpdate = false;
                Config.getInstance().dailyUpdate = false;
                Config.getInstance().toFile(STATIC.settingsPath);
                System.out.println("Debugmode: " + STATIC.dailyUpdate);
                channel.sendMessage("Debugmode: " + STATIC.dailyUpdate).queue();
            }
        }
    }
}