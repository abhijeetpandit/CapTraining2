package org.abhi.s1.datamodel;

public class Employee {
	private String kinId;
	private String empFirstName;
	private String empLastName;
	private String mobileNo;
	private String emailId;
	
	public Employee() {
	}
	
	
	public Employee(String kinId, String empFirstName, String empLastName,
			String mobileNo, String emailId) {
		this.kinId = kinId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}

	public String getKinId() {
		return kinId;
	}
	public void setKinId(String kinId) {
		this.kinId = kinId;
	}
	public String getEmpFirstName() {
		return empFirstName;
	}
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	public String getEmpLastName() {
		return empLastName;
	}
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	@Override
	public String toString() {
		return "Employee [kinId=" + kinId + ", empFirstName=" + empFirstName
				+ ", empLastName=" + empLastName + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + "]";
	}
}