package com.keanunichols.witherhunter;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public long randomNumberTime(){
		long leftLimit = 1200L;
	    long rightLimit = 1800L;
	    long generatedLong = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
		return generatedLong;
	}
	
	@Override
	public void onEnable() {
		JavaPlugin plugin = this;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable()
        {
            public void run()
            {			
            	int numPlayers = Bukkit.getOnlinePlayers().size();
            	if(numPlayers > 0){
            		int random = new Random().nextInt(numPlayers);
            		Player plr = (Player)Bukkit.getOnlinePlayers().toArray()[random];
            		SpawnWither sWither = new SpawnWither();
            		sWither.spawnWither(plr);
            	}
            }
        }, 1200L, randomNumberTime());
	}

}
