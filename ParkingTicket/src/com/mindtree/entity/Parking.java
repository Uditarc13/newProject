package com.mindtree.entity;

public class Parking
{

	private String vehicleNumber;
	private String entryTime;
	
	public Parking() 
	{
		super();
		vehicleNumber="";
		entryTime="";
		
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	
	
}
