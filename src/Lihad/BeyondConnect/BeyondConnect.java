package Lihad.BeyondConnect;

import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import Lihad.BeyondConnect.JSON.JSONConnection;
import Lihad.BeyondConnect.Listeners.BeyondPlayerListener;
import Lihad.BeyondConnect.Listeners.BeyondPluginListener;
import Lihad.BeyondConnect.Util.BeyondTimerTask;
import Lihad.BeyondConnect.Util.UpdateTimer;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class BeyondConnect extends JavaPlugin {
	public static PermissionHandler handler;
	public static JSONConnection connection;
	private final BeyondPluginListener pluginListener = new BeyondPluginListener(this);
	private final BeyondPlayerListener playerListener = new BeyondPlayerListener(this);

	public static boolean permissionsEngaged;
	public static boolean streamEngaged;

    public static UpdateTimer timer;
    public static BeyondTimerTask task;

	
	@Override
	public void onDisable() {
		System.out.println("[BeyondConnect] has disabled");		
	}

	@Override
	public void onEnable() {
		System.out.println("-----------------------------------------");

		//ClassManager
		connection = new JSONConnection(this);
	
		//PermsManager
		setupPermissions();
		
		//PluginManager
		PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(playerListener,this);
        pm.registerEvents(pluginListener,this);

        //StreamManager
        connection.connect();
        
		//TimerManager
		task = new BeyondTimerTask();
		timer = new UpdateTimer(this);
        
        //OutputManager
		if(streamEngaged)System.out.println("[BeyondConnect] BeyondMinecraft.net is Connected and Streaming");
		if(permissionsEngaged)System.out.println("[BeyondConnect] Permissions is Active");
		System.out.println("[BeyondConnect] has launched successfully");
		System.out.println("-----------------------------------------");
	}

	public void setupPermissions() {
		Plugin permissionsPlugin = this.getServer().getPluginManager().getPlugin("Permissions");
		
		if (permissionsPlugin != null) {
			handler = ((Permissions) permissionsPlugin).getHandler();
			permissionsEngaged = true;

		} else {
			System.out.println("[BeyondConnect] Permissions has failed to connect");

			permissionsEngaged = false;
		}
	}

}
