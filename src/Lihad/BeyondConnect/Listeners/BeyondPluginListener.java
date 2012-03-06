package Lihad.BeyondConnect.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;

import Lihad.BeyondConnect.BeyondConnect;


public class BeyondPluginListener implements Listener {
	public static BeyondConnect plugin;
    public BeyondPluginListener(BeyondConnect instance) {
        plugin = instance;
    }
    @EventHandler
    public void onPluginEnable(PluginEnableEvent event){
    	if((event.getPlugin().getDescription().getName().equals("Permissions"))) plugin.setupPermissions();
    }
}
