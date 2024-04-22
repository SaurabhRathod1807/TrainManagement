package com.example.SpringProjects.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long trainid;
	public String source;
	public String Destation;
	public double time;
	public Train() {
		super();
	}
	public Train(Long trainid, String source, String destation, double time) {
		super();
		this.trainid = trainid;
		this.source = source;
		Destation = destation;
		this.time = time;
	}
	public Long getTrainid() {
		return trainid;
	}
	public void setTrainid(Long trainid) {
		this.trainid = trainid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestation() {
		return Destation;
	}
	public void setDestation(String destation) {
		Destation = destation;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Train [trainid=" + trainid + ", source=" + source + ", Destation=" + Destation + ", time=" + time + "]";
	}
	
	
}
