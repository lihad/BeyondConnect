package Lihad.BeyondConnect.Util;

import java.util.TimerTask;

import Lihad.BeyondConnect.BeyondConnect;



public class BeyondTimerTask extends TimerTask {
	public static boolean acquired = true;

	@Override
	public void run(){
		try{
			acquired = false;
			BeyondConnect.connection.reconnect();
			acquired = true;
		}catch(Exception e){
			System.out.println("TimerTask has failed to complete.  Exception encountered.");
			e.printStackTrace();
		}
	}
}
