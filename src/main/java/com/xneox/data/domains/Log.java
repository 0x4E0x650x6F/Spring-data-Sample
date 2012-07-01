package com.xneox.data.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User Entity class
 * 
 * @author neo
 */
@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer error;
	private Long timestap;
	private String local;
	private String process;
	private String service;
	private String inputMessage;
	private String outPutMessage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public Long getTimestap() {
		return timestap;
	}
	public void setTimestap(Long timestap) {
		this.timestap = timestap;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getInputMessage() {
		return inputMessage;
	}
	public void setInputMessage(String inputMessage) {
		this.inputMessage = inputMessage;
	}
	public String getOutPutMessage() {
		return outPutMessage;
	}
	public void setOutPutMessage(String outPutMessage) {
		this.outPutMessage = outPutMessage;
	}

}
