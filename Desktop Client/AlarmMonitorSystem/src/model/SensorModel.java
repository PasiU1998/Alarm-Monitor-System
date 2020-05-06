/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author optane
 */
public class SensorModel {

    int SensorId;

    String SesorStatus;

    String FloorNumber;

    String RoomNumber;

    int SmokeLevel;

    int Co2Level;

    public SensorModel() {
    }
       

    public SensorModel(int SensorId, String SesorStatus, String FloorNumber, String RoomNumber, int SmokeLevel, int Co2Level) {
        this.SensorId = SensorId;
        this.SesorStatus = SesorStatus;
        this.FloorNumber = FloorNumber;
        this.RoomNumber = RoomNumber;
        this.SmokeLevel = SmokeLevel;
        this.Co2Level = Co2Level;
    }    
    

    public int getSensorId() {
        return SensorId;
    }

    public void setSensorId(int SensorId) {
        this.SensorId = SensorId;
    }

    public String getSesorStatus() {
        return SesorStatus;
    }

    public void setSesorStatus(String SesorStatus) {
        this.SesorStatus = SesorStatus;
    }

    public String getFloorNumber() {
        return FloorNumber;
    }

    public void setFloorNumber(String FloorNumber) {
        this.FloorNumber = FloorNumber;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }

    public int getSmokeLevel() {
        return SmokeLevel;
    }

    public void setSmokeLevel(int SmokeLevel) {
        this.SmokeLevel = SmokeLevel;
    }

    public int getCo2Level() {
        return Co2Level;
    }

    public void setCo2Level(int Co2Level) {
        this.Co2Level = Co2Level;
    }
    
    
  
    

}
