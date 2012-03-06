package Lihad.BeyondConnect.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import Lihad.BeyondConnect.BeyondConnect;
import Lihad.BeyondConnect.JSON.JSONConnection;
import Lihad.BeyondConnect.Util.BeyondTimerTask;

public class BeyondPlayerListener implements Listener {
	public static BeyondConnect plugin;
	public BeyondPlayerListener(BeyondConnect instance) {
		plugin = instance;
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		try{
			if(event.getClickedBlock().getType() == Material.SPONGE && BeyondConnect.handler.inGroup(event.getPlayer().getWorld().getName(), event.getPlayer().getName(), "Drifter")){
				System.out.println("-------------------CONNECTION-DEBUG-----------");
				System.out.println("Sponge hit by player: "+event.getPlayer());
				if(BeyondTimerTask.acquired && JSONConnection.stream.toString().toLowerCase().contains(("\""+event.getPlayer().getName()+"\"").toLowerCase())){
					System.out.println("Player "+event.getPlayer().getName()+" was found.  Promoted");
					plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "pex promote "+event.getPlayer().getName());
					event.getPlayer().sendMessage(ChatColor.BLUE.toString()+"Congrats!  You've been accepted!!! You can leave this area now");

				}else{
					System.out.println("Player "+event.getPlayer().getName()+" was not contained in the Master File");
					event.getPlayer().damage(8);
					event.getPlayer().sendMessage(ChatColor.BLUE.toString()+"----------------------------------------------");
					event.getPlayer().sendMessage(ChatColor.BLUE.toString()+"You Haven't Registered Yet! You Must Do So First");
					event.getPlayer().sendMessage(ChatColor.BLUE.toString()+"Please Go To BeyondMinecraft.net and Register!");
					event.getPlayer().sendMessage(ChatColor.BLUE.toString()+"If you did register, wait 30sec and try again!");
					event.getPlayer().sendMessage(ChatColor.BLUE.toString()+"----------------------------------------------");
				}
				System.out.println("----------------------------------------------");

			}
		}catch(NullPointerException e){
			
		}
	}
}
