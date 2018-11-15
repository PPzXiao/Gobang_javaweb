package com.entity;

public class Admin {
    private int ADID;
    private String ADname;
    private String ADpassword;
//    private String ADrigisterdate;
    private String ADemail;
	public int getID() {
		return ADID;
	}
	public void setID(int ADID) {
		this.ADID = ADID;
	}
	public String getName() {
		return ADname;
	}
	public void setName(String ADname) {
		this.ADname = ADname;
	}
	public String getPwd() {
		return ADpassword;
	}
	public void setPwd(String ADpassword) {
		this.ADpassword = ADpassword;
	}
//	public String getDate() {
//		return ADrigisterdate;
//	}
//	public void setDate(String ADrigisterdate) {
//		this.ADrigisterdate = ADrigisterdate;
//	}
	public String getEmail() {
		return ADemail;
	}
	public void setEmail(String ADemail) {
		this.ADemail = ADemail;
	}
}
