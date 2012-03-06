package Lihad.BeyondConnect.JSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;

import Lihad.BeyondConnect.BeyondConnect;

public class JSONConnection {

	public static BeyondConnect plugin;
	public static StringBuilder stream = new StringBuilder();;
	
	public JSONConnection(BeyondConnect instance){
		plugin = instance;
	}
	
	public void connect(){
		stream = null;
		String line;
		URL url;
		try {
			url = new URL("http://www.beyondminecraft.net/api/get-users");
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setDoOutput(true);
    	    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    	    while ((line = rd.readLine()) != null) {
    			stream.append(line);
    	    }
    	    rd.close();
			BeyondConnect.streamEngaged = true;
		} catch (Exception e) {
			BeyondConnect.streamEngaged = false;
			System.out.println("[BeyondConnect] A Fatal Error Occured Attempting to Connect");
		}
	}
	public void reconnect(){
		connect();
	}
}
