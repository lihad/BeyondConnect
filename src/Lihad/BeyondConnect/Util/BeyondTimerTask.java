package Lihad.BeyondConnect.Util;

import java.util.List;
import java.util.TimerTask;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import Lihad.BeyondConnect.BeyondConnect;


public class BeyondTimerTask extends TimerTask {

	@Override
	public void run(){
		try{
			BeyondConnect.connection.reconnect();
		}catch(Exception e){
			System.out.println("TimerTask has failed to complete.  Exception encountered.");
			e.printStackTrace();
		}
	}
}
