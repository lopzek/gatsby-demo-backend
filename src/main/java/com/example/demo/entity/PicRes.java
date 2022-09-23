package com.example.demo.entity;

import java.util.Objects;

public class PicRes {
	
	private String message;
	private String status;

	public PicRes(String message, String status) {
		super();
		this.message = message;
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PicRes other = (PicRes) obj;
		return Objects.equals(message, other.message) && Objects.equals(status, other.status);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PicRes() {
		// TODO Auto-generated constructor stub
	}

}
