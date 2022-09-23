package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PicInfo {
	@Id
	private String id;
	
	private String picUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public PicInfo(String id, String picUrl) {
		super();
		this.id = id;
		this.picUrl = picUrl;
	}

	public PicInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PicInfo [id=" + id + ", picUrl=" + picUrl + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, picUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PicInfo other = (PicInfo) obj;
		return Objects.equals(id, other.id) && Objects.equals(picUrl, other.picUrl);
	}



}
