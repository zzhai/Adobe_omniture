package com.adobe.omniture.rest.model;

import java.util.List;
import java.util.Map;

public class ReportQueueDescription {

	private String reportSuiteID;
	private String date;
	private String dateFrom;
	private String dateTo;
	private String dateGranularity;
	private List<Map<String, String>> metrics;
	private String sortBy;
	private List<Map<String, String>> elements;
	private String currentData;
	public String getReportSuiteID() {
		return reportSuiteID;
	}
	public void setReportSuiteID(String reportSuiteID) {
		this.reportSuiteID = reportSuiteID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public String getDateGranularity() {
		return dateGranularity;
	}
	public void setDateGranularity(String dateGranularity) {
		this.dateGranularity = dateGranularity;
	}
	public List<Map<String, String>> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<Map<String, String>> metrics) {
		this.metrics = metrics;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public List<Map<String, String>> getElements() {
		return elements;
	}
	public void setElements(List<Map<String, String>> elements) {
		this.elements = elements;
	}
	public String getCurrentData() {
		return currentData;
	}
	public void setCurrentData(String currentData) {
		this.currentData = currentData;
	}
	
}
