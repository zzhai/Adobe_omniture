package com.adobe.omniture.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompanyGetEndpointRequest {
	private String company;
	
	public CompanyGetEndpointRequest() {
	}

	public CompanyGetEndpointRequest(String company) {
		this.company = company;
	}
	
	@XmlElement
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
