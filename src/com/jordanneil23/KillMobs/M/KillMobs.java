package com.jordanneil23.KillMobs.M;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.*;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class KillMobs extends JavaPlugin {
	public static java.util.logging.Logger log = java.util.logging.Logger.getLogger("Minecraft");
	public static boolean AutoConfig = true;
	public static boolean AutoKill = false;
	public static boolean ops = true;
	public static boolean permsex = false;
	public static boolean superperms = false;
	public static boolean spawners = true;
	public void onEnable() {
		try {
			ConfigurationHandler.firstRun();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConfigurationHandler.loadYamls();
		PermissionsHandler.setupPermissions();
		PluginDescriptionFile pdf = this.getDescription();
		log.info("[KillMobs] Version " + pdf.getVersion() + " enabled.");
		if(AutoKill == true){
			log.info("[KillMobs] AutoKill is enabled... Going to kill dem mobs!");
			killOnStart();
		}
	}
	
	public void onDisable(){
		PluginDescriptionFile pdf = this.getDescription();
		log.info("[KillMobs] Version " + pdf.getVersion() + " disabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		if (command.getName().toLowerCase().equalsIgnoreCase("KillMobs")|| command.getName().toLowerCase().equalsIgnoreCase("KMobs"))
	    {
			if (args.length == 0){
				sender.sendMessage("--- KillMobs Help ---");
				sender.sendMessage("<> - Mandatory");
				sender.sendMessage("() - Optional");
				sender.sendMessage("This should only be used in emergencies. Like if someone spawned too many mobs.");
				sender.sendMessage("/KillMobs <world> (mob) - Kill all mobs or all of given (mob) on given <world>.");
				sender.sendMessage("This will only kill tamed ocelots and wolves if you tell it to do so. Ex:");
				sender.sendMessage("/KillMobs world twolf - Kill all tamed wolves.");
				sender.sendMessage("/KillMobs world tocelot - Kill all tamed ocelots.");
				return true;
			}
			if (Bukkit.getServer().getWorld(args[0]) != null){
				if (args.length == 1){
					Kill(Bukkit.getServer().getWorld(args[0]), "all");
					sender.sendMessage("Kill all mobs on world '" + args[0] + "'!");
					return true;
				}else {
				Kill(Bukkit.getServer().getWorld(args[0]), args[1]);
				sender.sendMessage("Kill all "+ args[1] +" on world '" + args[0] + "'!");
				return true;
				}
			}else{
				
			}
			
	    }
		return false;
}
	
	public static void Kill(World wd, String what) {
		List<Entity> w = wd.getEntities();
        for (Entity m : w)
        {
						if (m instanceof Bat && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("bat") )) {
							m.remove();
						}else if (m instanceof Chicken && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("chicken") )) {
							m.remove();
						} else if (m instanceof Cow && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("cow") )) {
							m.remove();
						}else if (m instanceof Horse && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("horse") )) {
							m.remove();
						}else if (m instanceof IronGolem && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("irongolem") )) {
							m.remove();
						}else if (m instanceof Pig && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("pig") )) {
							m.remove();
						} else if (m instanceof Sheep && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("sheep") )) {
							m.remove();
						} else if (m instanceof MushroomCow && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("mooshroom") )) {
							m.remove();
						} else if (m instanceof Ocelot && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("ocelot") )) {
							if (((Ocelot) m).isTamed() == false) {
								m.remove();
					        	}else{}
						}else if (m instanceof Ocelot && what.equalsIgnoreCase("TOcelot")) {
							 if (((Ocelot) m).isTamed() == true) {
								 m.remove();
						        	}else{}
						} else if (m instanceof Snowman && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("snowman") )) {
							m.remove();
						} else if (m instanceof Wolf && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("wolf") )) {
							if (((Wolf) m).isTamed() != true) {
								m.remove();
					        	}else{}
						}else if (m instanceof Wolf && what.equalsIgnoreCase("TWolf")) {
							 if (((Wolf) m).isTamed() == true) {
								 m.remove();
						        	}else{}
						}
						if (m instanceof Zombie && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("zombie") )) {
							m.remove();
						}else if (m instanceof Blaze && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("blaze") )) {
							m.remove();
						} else if (m instanceof Creeper && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("creeper") )) {
							m.remove();
						} else if (m instanceof PigZombie && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("pigzombie") )) {
							m.remove();
						} else if (m instanceof Giant && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("giant") )) {
							m.remove();
						} else if (m instanceof MagmaCube && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("magmacube") )) {
							m.remove();
						} else if (m instanceof Skeleton && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("skeleton") )) {
							m.remove();
						} else if (m instanceof Spider && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("spider") )) {
							m.remove();
						} else if (m instanceof Slime && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("slime") )) {
							m.remove();
						} else if (m instanceof Silverfish && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("silverfish") )) {
							m.remove();
						} else if (m instanceof CaveSpider && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("cavespider") )) {
							m.remove();
						} else if (m instanceof Enderman && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("enderman") )) {
							m.remove();
						}
						if (m instanceof Squid && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("squid") )) {
							m.remove();
					}
					if (m instanceof Ghast && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("ghast") )) {
						m.remove();
					}
				if (m instanceof EnderDragon && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("enderdragon") )) {
					m.remove();
				}
				if (m instanceof Wither && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("wither") )) {
					m.remove();
				}
				if (m instanceof Villager && (what.equalsIgnoreCase("all") || what.equalsIgnoreCase("villager") )) {
					m.remove();
				} 
			}
			return;
        }
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void killOnStart(){
		FileConfiguration config = YamlConfiguration.loadConfiguration(ConfigurationHandler.file);
		World wd = null;
		String input = config.getString("KillMobs.World");
		String output = input.substring(input.indexOf("[")+1,input.lastIndexOf("]"));
		if (Bukkit.getServer().getWorld(output) != null){
				wd = Bukkit.getServer().getWorld(output);
		}
		
		if (wd == null){
			log.info("[KillMobs] A valid world was not listed" + output);
			return;
		}
	          Object[] mobs = config.getList("KillMobs.Mobs").toArray();
	          ArrayList kit = new ArrayList(Arrays.asList(mobs));
	          if (kit.isEmpty()){
	        	  log.info("[KillMobs] No mobs were listed.");
	        	  return;
	          }
	          if (mobs.length != 0)
	          {
				for (Iterator iter = kit.listIterator(); iter.hasNext();){
					Kill(wd, iter.next().toString().toUpperCase());
				}
	            return;
	          }else{
	        	  log.info("[KillMobs] Woah now, you didn't list any mobs!");
	  			return;
	          }


	}
	}