package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Gatepass")
public class GatePass {
	
	public String vehicleNumber;
	public String transporterName;
	public String timeEntered;
	public String timeLeft;
	public String partyName;
	public String items;
	public String manager;
	public String billNumber;
	
	@Id
	public String po;
	

	public GatePass() {
		// TODO Auto-generated constructor stub
	}
	

	public GatePass(String vehicleNumber, String transporterName, String timeEntered, String timeLeft, String partyName,
			String items, String manager, String billNumber, String po) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.transporterName = transporterName;
		this.timeEntered = timeEntered;
		this.timeLeft = timeLeft;
		this.partyName = partyName;
		this.items = items;
		this.manager = manager;
		this.billNumber = billNumber;
		this.po = po;
	}



	public String getVehicleNumber() {
		return vehicleNumber;
	}


	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}


	public String getTransporterName() {
		return transporterName;
	}


	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}


	public String getTimeEntered() {
		return timeEntered;
	}


	public void setTimeEntered(String timeEntered) {
		this.timeEntered = timeEntered;
	}


	public String getTimeLeft() {
		return timeLeft;
	}


	public void setTimeLeft(String timeLeft) {
		this.timeLeft = timeLeft;
	}


	public String getPartyName() {
		return partyName;
	}


	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}


	public String getItems() {
		return items;
	}


	public void setItems(String items) {
		this.items = items;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getBillNumber() {
		return billNumber;
	}


	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}


	public String getPo() {
		return po;
	}


	public void setPo(String po) {
		this.po = po;
	}
	

}
