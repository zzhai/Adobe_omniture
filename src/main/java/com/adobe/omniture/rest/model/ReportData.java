package com.adobe.omniture.rest.model;

import java.util.List;

public class ReportData {
	
	private String name;
	private String url;
	private List<String> counts;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getCounts() {
		return counts;
	}
	public void setCounts(List<String> counts) {
		this.counts = counts;
	}
	
}
