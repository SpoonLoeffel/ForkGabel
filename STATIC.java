import java.io.*;
/**
 * Abstract class STATIC - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class STATIC
{
    // instance variables - replace the example below with your own
    public static final String VERSION = "0.3.4";
    public static final String token = "Insert Token Here";
    public static final String path = "Insert Target Folder AND/OR File Name here";
    public static final String fileUrl = "https://eddb.io/archive/v5/systems_populated.json";
    public static final int ourFaction = 75448;
    public static final String eliteChannel = "Channel Name Here";
    public static final String eliteChannelId = "Channel ID Here";
    public static final String eliteGeneralId = "Channel ID Here";
}


/**
 * TODO
 * Make daily update time changable on the fly
 * make some of the STATIC variables read from file or something, but token needs to go away
 * clean up import list
 * figure out how to check if it already send the daily update today
 * find better solution to the json fix in minor factions
 */