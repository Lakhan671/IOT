package com.os.biz.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auditlogs")
public class AuditLogs  implements Serializable{
	private static final long serialVersionUID = 2460978205784565559L;
	@Id
	private String id;
	private String request;
	private String response;
	private String date;
	private String serviceId;
	public AuditLogs(String request, String response, String date, String serviceId) {
		this.request = request;
		this.response = response;
		this.date = date;
		this.serviceId = serviceId;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
