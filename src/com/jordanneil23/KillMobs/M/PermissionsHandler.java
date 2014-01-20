package com.jordanneil23.KillMobs.M;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;

import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class PermissionsHandler {
	public static java.util.logging.Logger log = java.util.logging.Logger.getLogger("Minecraft");
	public static PermissionManager PermissionsEX = null;
    

    public static void setupPermissions() {
        if(Bukkit.getServer().getPluginManager().getPlugin("PermissionsEx") != null && KillMobs.AutoConfig == true){
        	KillMobs.permsex = true;
        	KillMobs.superperms = false;
        	ConfigurationHandler.setConfig("KillMobs.Permissions.PermissionsEx", true);
        	ConfigurationHandler.setConfig("KillMobs.Permissions.OpsOnly", false);
        	ConfigurationHandler.setConfig("KillMobs.Permissions.SuperPerms", false);
        }
            if (KillMobs.permsex != false || KillMobs.superperms != false) {
            	if (KillMobs.permsex == true){
            		if(Bukkit.getServer().getPluginManager().getPlugin("PermissionsEx") == null){
            			log.warning("[KillMobs] PermissionsEx is set to true in config but was not found!");
            			log.warning("[KillMobs] Going to use ops.txt!");
            			KillMobs.ops = true;
            			ConfigurationHandler.setConfig("KillMobs.Permissions.PermissionsEx", false);
                    	ConfigurationHandler.setConfig("KillMobs.Permissions.OpsOnly", true);
                    	ConfigurationHandler.setConfig("KillMobs.Permissions.SuperPerms", false);
            			return;
            		}
            		else
            		{
            		PermissionsEX = PermissionsEx.getPermissionManager();
            		 log.info("[KillMobs] Using PermissionsEx.");
            		 KillMobs.superperms = false;
            		 KillMobs.ops = false;
            		 return;
            		}
            	}else 
            		if (KillMobs.superperms == true){
            			log.info("[KillMobs] Using SuperPerms.");
            			KillMobs.superperms = true;
            			KillMobs.permsex = false;
            			KillMobs.ops = false;
            			return;
            		}
            	
            	return;
            	}
            else
            {
            	log.info("[KillMobs] In Ops only mode. Only ops will be able to use the command.");
                KillMobs.ops = true;
                return;
            }
    }
    
    public static void setPerms(String s){
    	PluginManager pm = Bukkit.getServer().getPluginManager();
    	pm.addPermission(new Permission(s));
    }
    
    void remPerms(String s){
    	PluginManager pm = Bukkit.getServer().getPluginManager();
    	pm.removePermission(s);
    }
    
    public static boolean playerhas(Player p, String perm, boolean ops){
    	if (ops == true)
    	{
    		if (!p.isOp())
    			return false;
    		else 
    			return true;
    	}
    	if (ops == false)
    	{
    		if (((KillMobs.superperms ? !p.hasPermission(perm) : (KillMobs.permsex ? !PermissionsEX.has(p, perm) : !p.isOp()))))
    			return false;
    		else
    			return true;
    	} 
		return true;
    }
}

