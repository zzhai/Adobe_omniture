package com.adobe.omniture.rest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adobe.omniture.rest.model.CompanyGetEndpointRequest;
import com.adobe.omniture.rest.model.ReportQueueDescription;
import com.adobe.omniture.rest.model.ReportQueueRequest;
import com.adobe.omniture.rest.model.ReportQueueResponse;
import com.adobe.omniture.rest.model.ReportRequest;
import com.adobe.omniture.rest.model.ReportResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	static String basePath = "https://api.omniture.com/admin/1.4/rest/";
	static String company = "company_name";
	static String username = "user:company";
	static String secret = "secret_code";

	public static void main(String[] args) {

		try {
			//
			Client client = ClientBuilder.newClient();

			Response response = invokeCompanyGetEndpoint(client);

			System.out.println(response.getStatus());

			if (response.getStatus() == 200) {
				String c = response.readEntity(String.class);
				System.out.println(c);
				ObjectMapper mapper = new ObjectMapper();
				
				basePath = mapper.readValue(c, String.class);
			}
			
			// Many parameters are hard coded inside invokeReportQueue method, you should customize them

			response = invokeReportQueue(client);

			ReportQueueResponse c = null;
			if (response.getStatus() == 200) {
				
				ReportResponse r = null;
				c = response.readEntity(ReportQueueResponse.class);
				int count = 0;
				while (true) {
					r = invokeReportGet(client, c);
					if (r.getError() != null && "report_not_ready".equals(r.getError())) {
						count++;
						System.out.println(r.getError_description() + " - Check n. " + count);
						Thread.sleep(2000);
						continue;
					}
					break;
				}
				
				System.out.println(r.getReport().getData().size());
				System.out.println("completed.");
				
			}
			
			
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param client
	 * @param c
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private static ReportResponse invokeReportGet(Client client, ReportQueueResponse c) throws IOException,
			NoSuchAlgorithmException {
		WebTarget target;
		Response response;
		System.out.println(c.getReportID());
		ReportRequest reportRequest = new ReportRequest();
		reportRequest.setReportID("" + c.getReportID());
		Entity<ReportRequest> entityReportRequest = Entity.entity(reportRequest, MediaType.APPLICATION_JSON);

		target = client.target(basePath);
		target = target.queryParam("method", "Report.Get");

		response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("X-WSSE", getHeaderXWSSE())
				.acceptEncoding("")
				.post(entityReportRequest);
		
		ReportResponse r = response.readEntity(ReportResponse.class);
		return r;
	}
	
	private static String getHeaderXWSSE() throws NoSuchAlgorithmException, IOException {
		return GatewayUtils.generateWSSEHeader(username, secret);
	}

	/**
	 * @param client
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private static Response invokeReportQueue(Client client) throws IOException, NoSuchAlgorithmException {
		WebTarget target;
		Response response;
		target = client.target(basePath);
		target = target.queryParam("method", "Report.Queue");

		Map<String, String> element = new HashMap<String, String>();
		element.put("id", "prop6");
		element.put("top", "50000");
		element.put("startingWith", "1	");
		List<Map<String, String>> elements = new ArrayList<Map<String, String>>();
		elements.add(element);

		Map<String, String> metric = new HashMap<String, String>();
		metric.put("id", "instances");
		List<Map<String, String>> metrics = new ArrayList<Map<String, String>>();
		metrics.add(metric);

		ReportQueueRequest rqr = new ReportQueueRequest();
		ReportQueueDescription rqd = new ReportQueueDescription();
		rqd.setReportSuiteID("globalproduction");
		rqd.setDate("");
		rqd.setDateFrom("2015-12-11");
		rqd.setDateTo("2015-12-17");
		rqd.setDateGranularity("");
		rqd.setMetrics(metrics);
		rqd.setSortBy("");
		rqd.setElements(elements);
		rqd.setCurrentData("true");
		rqr.setReportDescription(rqd);
		Entity<ReportQueueRequest> entityReportQueueRequest = Entity.entity(rqr,
				MediaType.APPLICATION_JSON);
		response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("X-WSSE", getHeaderXWSSE())
				.header("Accept-Encoding", null)
				.post(entityReportQueueRequest);
		return response;
	}

	/**
	 * @param client
	 * @return
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private static Response invokeCompanyGetEndpoint(Client client) throws IOException, NoSuchAlgorithmException {
		WebTarget target = client.target(basePath);
		target = target.queryParam("method", "Company.GetEndpoint");

		Entity<CompanyGetEndpointRequest> entityGetEndpoint = Entity.entity(new CompanyGetEndpointRequest(company),
				MediaType.APPLICATION_JSON);
		Response response = target
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.header("Accept-Encoding", null)
				.header("X-WSSE", getHeaderXWSSE())
				.post(entityGetEndpoint);
		return response;
	}
}
