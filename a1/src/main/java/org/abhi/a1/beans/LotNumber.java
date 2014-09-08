package org.abhi.a1.beans;

public class LotNumber {
	private Integer number;
	private Integer occurance;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getOccurance() {
		return occurance;
	}
	public void setOccurance(Integer occurance) {
		this.occurance = occurance;
	}
	@Override
	public String toString() {
		return "LotNumber [number=" + number + ", occurance=" + occurance + "]";
	}
	
}
