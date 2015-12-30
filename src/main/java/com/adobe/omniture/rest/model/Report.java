package com.adobe.omniture.rest.model;

import java.util.List;
import java.util.Map;

public class Report {
	
	private String type;
	private List<Map<String, String>> elements;
	private Map<String, String> reportSuite;
	private String period;
	private List<Map<String, String>> metrics;
	private List<ReportData> data;
	private List<String> totals;
	private String version;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Map<String, String>> getElements() {
		return elements;
	}
	public void setElements(List<Map<String, String>> elements) {
		this.elements = elements;
	}
	public Map<String, String> getReportSuite() {
		return reportSuite;
	}
	public void setReportSuite(Map<String, String> reportSuite) {
		this.reportSuite = reportSuite;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public List<Map<String, String>> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<Map<String, String>> metrics) {
		this.metrics = metrics;
	}
	public List<ReportData> getData() {
		return data;
	}
	public void setData(List<ReportData> data) {
		this.data = data;
	}
	public List<String> getTotals() {
		return totals;
	}
	public void setTotals(List<String> totals) {
		this.totals = totals;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}


}
