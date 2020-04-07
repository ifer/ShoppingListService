package ifer.web.shopping.controller;

public class ResponseMessage {
	
	private int status;
	private String message;
	private String data;
	
	
	
	public ResponseMessage() {
		super();
	}



	public ResponseMessage(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	

	public ResponseMessage(int status, String message, String data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}



	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
