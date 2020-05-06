/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author optane
 */
public class AlarmMonitorServerRemote extends UnicastRemoteObject implements AlamMonitorServer {

    protected AlarmMonitorServerRemote() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public String getSensor() throws Exception {
        
        URL obj = new URL("http://localhost:9090/API/Service/AlamMonitor");
         
        HttpURLConnection getConnection = (HttpURLConnection) obj.openConnection();
	getConnection.setRequestMethod("GET");
	getConnection.setRequestProperty("Content-Type", "application/json");
        
        int responseCode = getConnection.getResponseCode();
        
        if (responseCode == 200) {
			
            BufferedReader in = new BufferedReader(new InputStreamReader(getConnection.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

          //  JSONParser parse = new JSONParser();

          //  try {
          //      JSONObject jobj = (JSONObject)parse.parse(content.toString());
          //     System.out.println(jobj);
          //  } catch (Exception e) {
          //      // TODO Auto-generated catch block
          //       e.printStackTrace();
          // }
            return content.toString();

        } else {
            return "Error";
        }
        
        
        
    }

    @Override
    public String addSensor(HashMap<String, String> sensor) throws Exception {
        
//        final String ADD_SENSOR_PARAMS =
//                "{\n" + "\"SENSOR_STATUS\":" + sensor.get("SENSOR_STATUS") + ",\r\n}" +
//                " \"FLOOR_NUMBER\": " + sensor.get("FLOOR_NUMBER") + ",\r\n}" +
//                " \"ROOM_NUMBER\": " + sensor.get("ROOM_NUMBER") + ",\r\n}" +
//                " \"SMOKE_LEVEL\": " + sensor.get("SMOKE_LEVEL") + ",\r\n}" +
//                " \"CO2_LEVEL\": " + sensor.get("CO2_LEVEL") + "\n}";
        		
        final String ADD_SENSOR_PARAMS = "{\n" + "\"SENSOR_STATUS\":"+"\""+sensor.get("SENSOR_STATUS")+"\",\r\n" +
		        "    \"FLOOR_NUMBER\":"+"\""+sensor.get("FLOOR_NUMBER")+"\",\r\n" +
		        "    \"ROOM_NUMBER\":"+"\""+sensor.get("ROOM_NUMBER")+"\",\r\n" +
		        "    \"SMOKE_LEVEL\":"+"\""+sensor.get("SMOKE_LEVEL")+"\",\r\n" +
                        "    \"CO2_LEVEL\":"+"\""+ sensor.get("CO2_LEVEL") +"\"\n}";
        
        System.out.println(ADD_SENSOR_PARAMS);
        
        URL obj = new URL("http://localhost:9090/API/Service/AlamMonitor");
        
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	postConnection.setRequestMethod("POST");
	//postConnection.setRequestProperty("Content-Type", "application/json");
	postConnection.setDoOutput(true);
        
        OutputStream os = postConnection.getOutputStream();
	os.write(ADD_SENSOR_PARAMS.getBytes());
	os.flush();
	os.close();
        
        int responseCode = postConnection.getResponseCode();
            //handle connection error
	if (responseCode == 200) {
            System.out.println("Inserted successfully");
            return "Inserted successfully";		
	} else {
            System.out.println("error");
            return "Error";
	}
        
        
    }

    @Override
    public String editSensor(HashMap<String, String> sensor) throws Exception {
        
         final String EDIT_SENSOR_PARAMS = "{\n" + "\"SENSOR_ID\": " + sensor.get("SENSOR_ID") + ",\r\n" + 
                " \"SENSOR_STATUS\": " + sensor.get("SENSOR_STATUS") + ",\r\n}" +
                " \"FLOOR_NUMBER\": " + sensor.get("FLOOR_NUMBER") + ",\r\n}" +
                " \"ROOM_NUMBER\": " + sensor.get("ROOM_NUMBER") + ",\r\n}" +
                " \"SMOKE_LEVEL\": " + sensor.get("SMOKE_LEVEL") + ",\r\n}" +
                " \"CO2_LEVEL\": " + sensor.get("CO2_LEVEL") + "\n}";
	
	URL obj = new URL("http://localhost:9090/API/Service/AlamMonitor");
        
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	postConnection.setRequestMethod("PUT");
	postConnection.setRequestProperty("Content-Type", "application/json");
	postConnection.setDoOutput(true);
        
        OutputStream os = postConnection.getOutputStream();
	os.write(EDIT_SENSOR_PARAMS.getBytes());
	os.flush();
	os.close();
        
        int responseCode = postConnection.getResponseCode();
	
        //handle connection error
	if (responseCode == 200) {
            return "Updated successfully";		
	} else {
            return "Error";
	}
        
        
    }

    @Override
    public String deleteSensor(int sensor_id) throws Exception {
        final String EDIT_SENSOR_PARAMS = "{\n" + "\"SENSOR_ID\": " + sensor_id + "\n";
	
	URL obj = new URL("http://localhost:9090/API/Service/AlamMonitor");
	
	HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	postConnection.setRequestMethod("DELETE");
	postConnection.setRequestProperty("Content-Type", "application/json");
	postConnection.setDoOutput(true);
	
	OutputStream os = postConnection.getOutputStream();
	os.write(EDIT_SENSOR_PARAMS.getBytes());
	os.flush();
	os.close();
	
	int responseCode = postConnection.getResponseCode();
	
        //handle connection error
	if (responseCode == 200) {
            return "Deleted successfully";		
	} else {
            return "Error";
	}
        
        
        
    }
    
    
    
    
}
