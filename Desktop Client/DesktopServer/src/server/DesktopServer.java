/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author optane
 */
public class DesktopServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {           
            
            AlamMonitorServer stub = (AlamMonitorServer) new AlarmMonitorServerRemote();
    		
            //binding the AlarmMonitorServerRemote object to the RMI
            Naming.rebind("rmi://localhost/5000", stub);
    		
            System.out.println("Server started");
            
    	} catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        
        
        }
    }
    
}
