/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.HashMap;
import model.SensorModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author optane
 */
public class ClientMain { 
       
    
    AlamMonitorServer service;
    public static ArrayList<SensorModel> sensoreIntialList ;
    
    
    public ArrayList<SensorModel> getSensoreList(){
        
        ArrayList<SensorModel> List = new ArrayList<>();
        
        try{
            
            service  = (AlamMonitorServer) Naming.lookup("rmi://localhost/5000");
            
            String output = service.getSensor();
            System.out.println(output);
            

            
            JSONArray array = new JSONArray(output);

            
            for(int i = 0 ; i < array.length() ; i++){
                
                SensorModel model = new SensorModel();
                
                model.setSensorId(array.getJSONObject(i).getInt("SENSOR_ID"));
                model.setSesorStatus(array.getJSONObject(i).getString("SENSOR_STATUS"));
                model.setFloorNumber(array.getJSONObject(i).getString("FLOOR_NUMBER"));
                model.setRoomNumber(array.getJSONObject(i).getString("ROOM_NUMBER"));
                model.setSmokeLevel(array.getJSONObject(i).getInt("SMOKE_LEVEL"));
                model.setCo2Level(array.getJSONObject(i).getInt("CO2_LEVEL"));
                
                List.add(model);
                
        }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return List;
    }
    
    
     //call the server to add the sensor details
    public void AddSensorDetails(HashMap<String, String> sensor) {
		
        try {
            service  = (AlamMonitorServer) Naming.lookup("rmi://localhost/5000");
               
            
            String val = service.addSensor(sensor);
            
            System.out.println(val);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
			
    } 
    
    //call the server to edit the sensor details
    public void EditSensorDetails(HashMap<String, String> sensor) {
		
        try {
            service  = (AlamMonitorServer) Naming.lookup("rmi://localhost/5000");

            service.editSensor(sensor);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
			
    }
    
    //call the server to delete the sensor details
    public void DeleteSensor(int sensor_id) {
		
        try {
            service  = (AlamMonitorServer) Naming.lookup("rmi://localhost/5000");

            service.deleteSensor(sensor_id);
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
			
    }
    
    
    
}
