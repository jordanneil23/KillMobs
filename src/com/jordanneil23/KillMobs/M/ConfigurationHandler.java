package com.jordanneil23.KillMobs.M;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigurationHandler {
	
	public static File file = new File("plugins/KillMobs/config.yml");
	public static FileConfiguration config = new YamlConfiguration();
	
	
	public static void firstRun() {
        if(!file.exists()){
        	file.getParentFile().mkdirs();
        
        	config.options().header("AutoKill will kill all listed mobs under the Mobs section that are in the provided World.");
        	if(!config.isSet("KillMobs.AutoKill")){
        		config.set("KillMobs.AutoKill", KillMobs.AutoKill);
        	}
        	if(!config.isSet("KillMobs.Mobs")){
        		config.set("KillMobs.Mobs", "");
        	}
        	if(!config.isSet("KillMobs.World")){
        		config.set("KillMobs.World", "");
        	}
        	if(!config.isSet("KillMobs.Permissions.AutoConfig")){
        		config.set("KillMobs.Permissions.AutoConfig", KillMobs.AutoConfig);
        	}
        	if(!config.isSet("KillMobs.Permissions.OpsOnly")){
        		config.set("KillMobs.Permissions.OpsOnly", KillMobs.ops);
        	}
        	if(!config.isSet("KillMobs.Permissions.PermissionsEx")){
        		config.set("KillMobs.Permissions.PermissionsEx", KillMobs.permsex);
        	}
        	if(!config.isSet("KillMobs.Permissions.SuperPerms")){
        		config.set("KillMobs.Permissions.SuperPerms", KillMobs.superperms);
        	}
        	try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
	
	public static void setConfig(String n, Object b){
		config.set(n, b);
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    public static boolean loadYamls() {
        try {
        	config.load(file);
        	KillMobs.AutoConfig =  config.getBoolean("KillMobs.Permissions.AutoConfig");
        	KillMobs.ops = config.getBoolean("KillMobs.Permissions.OpsOnly");
        	KillMobs.permsex = config.getBoolean("KillMobs.Permissions.PermissionsEX");
        	KillMobs.superperms = config.getBoolean("KillMobs.Permissions.SuperPerms");
        	KillMobs.AutoKill =  config.getBoolean("KillMobs.AutoKill");
			KillMobs.log.info("[KillMobs] Configuration files loaded.");
			return true;
        } catch (Exception e) {
        	KillMobs.log.info("[KillMobs] Configuration files not loaded, error:");
        	e.printStackTrace();
        	return false;
        }
    }
    
    public static boolean Data(String nodeData) {
		if (nodeData != null) {
			if (nodeData.equalsIgnoreCase("true")) {
				return false;
			}else if (nodeData.equalsIgnoreCase("false")){
				return false;
			}
		}
		return false;
	}
}


