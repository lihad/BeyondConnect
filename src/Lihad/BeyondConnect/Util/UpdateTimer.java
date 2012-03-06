package Lihad.BeyondConnect.Util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Lihad.BeyondConnect.BeyondConnect;


public class UpdateTimer {
	public static BeyondConnect plugin;
	public static Timer timer;
	public static Date date;
	
    public UpdateTimer(BeyondConnect instance) {
        plugin = instance;
        timer = new Timer();
    	
    	runnableTimer();
    }
    
    public void runnableTimer(){
    	System.out.println("[Religion] Timer has been set,.");
    	Calendar cal = Calendar.getInstance();    	
    	timer.scheduleAtFixedRate(BeyondConnect.task, cal.getTime(),  30000);
    }
}
