/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.util.HashMap;

/**
 *
 * @author optane
 */
public interface AlamMonitorServer  extends Remote{
   
  public String getSensor() throws Exception;
  public String addSensor(HashMap<String, String> sensor) throws Exception;
  public String editSensor(HashMap<String, String> sensor) throws Exception;
  public String deleteSensor(int sensor_id) throws Exception;
    
    
    
}
