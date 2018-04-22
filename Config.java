/*
 * Based on code from: Frank Roth
 * 
 * 
 * 
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Config {

    // Hier schreibst du deine Attribute hin
    public String discordToken;
    public String systemDBPath;
    public String systemDBFileURL;
    public int dailyUpdateHours;
    public int dailyUpdateMinutes;
    public boolean autoUpdate;
    public boolean dailyUpdate;

    public Config() {
        // Hier die Standardwerte der Attribute, falls diese
        // nicht in der Konfigurationsdatei vorhanden sind. 
        this.discordToken = "discord token";
        this.systemDBPath = "C:/Users/Administrator/AppData/Roaming/_ForkGabel/Data.json";
        this.systemDBFileURL = "https://eddb.io/archive/v5/systems_populated.json";
        this.dailyUpdateHours = 21;
        this.dailyUpdateMinutes = 0;
        this.autoUpdate = false;
        this.dailyUpdate = false;
    }

    // DON'T TOUCH THE FOLLOWING CODE
    private static Config instance;

    public static Config getInstance() {
        if (instance == null) {
            instance = fromDefaults();
        }
        return instance;
    }

    public static void load(File file) {
        instance = fromFile(file);

        // no config file found
        if (instance == null) {
            instance = fromDefaults();
        }
    }

    public static void load(String file) {
        load(new File(file));
    }

    private static Config fromDefaults() {
        Config config = new Config();
        return config;
    }

    public void toFile(String file) {
        toFile(new File(file));
    }

    public void toFile(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonConfig = gson.toJson(this);
        FileWriter writer;
        try {
            writer = new FileWriter(file);
            writer.write(jsonConfig);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Config fromFile(File configFile) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(configFile)));
            return gson.fromJson(reader, Config.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}