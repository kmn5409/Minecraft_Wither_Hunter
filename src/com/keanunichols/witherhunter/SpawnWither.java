package com.keanunichols.witherhunter;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.boss.BossBar;


public class SpawnWither{
	//Might have to think about what happens when you disconnect from the server
	//Maybe run a scheduler (no)
	//Thinking maybe will just remove wither close to player when they spawn
	//Might just kill all withers and then continue on
	
	protected int randomInt(int min, int max){
		int number = min + (int) (Math.random() * (max - min));
		return number;
	}

	protected void spawnWither(Player plr){
		/*
		Maybe check if wither is near player, if it is, then don't spawn another one
		 */
		Location pLocation = plr.getLocation();
		World wld = plr.getWorld();
		Chunk chunk = pLocation.getChunk();
		//int playerX = pLocation.getBlockX();
		int playerY = pLocation.getBlockY();
		//int playerZ = pLocation.getBlockZ();
		Random rand = new Random();
		Location randLoc = chunk.getBlock(rand.nextInt(16), playerY + randomInt(5,10),rand.nextInt(16)).getLocation();
		Entity wither = wld.spawnEntity(randLoc, EntityType.WITHER);
		Wither witherBoss = (Wither) wither;
		witherBoss.getBossBar().removeAll();
		//plr.sendMessage("Spawned wither");
	}
}
