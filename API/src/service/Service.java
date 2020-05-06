package service;

import javax.ws.rs.core.MediaType;

import java.awt.List;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

//For JSON
import com.google.gson.*;
import com.mysql.cj.xdevapi.JsonParser;

import controller.SensorController;
import model.SensorModel;



@Path("/AlamMonitor")
public class Service {
	
	
	SensorController sensorContrl = new SensorController();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String readSensore() {
		
		return sensorContrl.ReadSesor();
		
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
	public String InsertSensore(@FormParam("SENSOR_ID")int SensoreId ,
			@FormParam("SENSOR_STATUS")String SensoreStatus, @FormParam("FLOOR_NUMBER")String floorumber,
			@FormParam("ROOM_NUMBER")String roomnumber ,@FormParam("SMOKE_LEVEL")int smokelevel ,
			@FormParam("CO2_LEVEL")int co2level) {
		
		
		SensorModel sensOb = new SensorModel();
		
		sensOb.setSENSOR_ID(SensoreId);
		sensOb.setSENSOR_STATUS(SensoreStatus);
		sensOb.setFLOOR_NUMBER(floorumber);
		sensOb.setROOM_NUMBER(roomnumber);
		sensOb.setSMOKE_LEVEL(smokelevel);
		sensOb.setCO2_LEVEL(co2level);
		
		String output = sensorContrl.InsertSensor(sensOb);
		
		return output;
		
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
	public String UpdateSensore(@FormParam("SENSOR_ID")int SensoreId ,
			@FormParam("SENSOR_STATUS")String SensoreStatus, @FormParam("FLOOR_NUMBER")String floorumber,
			@FormParam("ROOM_NUMBER")String roomnumber ,@FormParam("SMOKE_LEVEL")int smokelevel ,
			@FormParam("CO2_LEVEL")int co2level) {
		
		
		SensorModel sensOb = new SensorModel();
		
		sensOb.setSENSOR_ID(SensoreId);
		sensOb.setSENSOR_STATUS(SensoreStatus);
		sensOb.setFLOOR_NUMBER(floorumber);
		sensOb.setROOM_NUMBER(roomnumber);
		sensOb.setSMOKE_LEVEL(smokelevel);
		sensOb.setCO2_LEVEL(co2level);
		
		String output = sensorContrl.UpdateSensore(sensOb);
		
		return output;
		
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN) 
	public String DeleteSensore(@FormParam("SENSOR_ID")int SensoreId ) {
		
		
		String Output = sensorContrl.DeleteSesore(SensoreId);
		
		return Output;
	}
	
	
	

}
