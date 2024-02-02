package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class GatePassEntries {

	@Id
	public String gatePassId;
	
	@DocumentReference
	private GatePass[] gatepasses;
	
	public GatePassEntries() {
		// TODO Auto-generated constructor stub
	}

	
	public GatePassEntries(String gatePassId, GatePass[] gatepasses) {
		super();
		this.gatePassId = gatePassId;
		this.gatepasses = gatepasses;
	}


	public String getId() {
		return gatePassId;
	}

	public void setId(String gatePassId) {
		this.gatePassId = gatePassId;
	}

	public GatePass[] getGatepasses() {
		return gatepasses;
	}

	public void setGatepasses(GatePass[] gatepasses) {
		this.gatepasses = gatepasses;
	}
	
	

}
