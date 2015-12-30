package com.adobe.omniture.rest.model;

public class ReportResponse {
	private Report report;
	private String waitSeconds;
	private String runSeconds;
	private String error;
	private String error_description;
	private String error_uri;

	/*
	 * {"error":"report_not_ready","error_description":"Report not ready","error_uri":null}
	 */
	
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public String getWaitSeconds() {
		return waitSeconds;
	}

	public void setWaitSeconds(String waitSeconds) {
		this.waitSeconds = waitSeconds;
	}

	public String getRunSeconds() {
		return runSeconds;
	}

	public void setRunSeconds(String runSeconds) {
		this.runSeconds = runSeconds;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}

	public String getError_uri() {
		return error_uri;
	}

	public void setError_uri(String error_uri) {
		this.error_uri = error_uri;
	}

	
}
