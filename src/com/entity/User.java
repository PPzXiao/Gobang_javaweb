package com.entity;

public class User {
   
	private int UserID;
    private String Nickname;
    private String Password;
    private String RigisterDate;
    private String Email;
    public String Question;
    public String Text;
    public String Date;
    public void setQuestion (String Question) {
		this.Question = Question;
    }
    
    public String getQuestion(){
    	return Question;
    }
    
    public void setText (String Text) {
 		this.Text = Text;
     }
     
     public String getText(){
     	return Text;
     }
    
     public String getDate2() {
 		return Date;
 	}
 	public void setDate2(String Date) {
 		this.Date = Date;
 	}
     
     
     
	public int getID() {
		return UserID;
	}
	public void setID(int UserID) {
		this.UserID = UserID;
	}
	public String getName() {
		return Nickname;
	}
	public void setName(String Nickname) {
		this.Nickname = Nickname;
	}
	public String getPwd() {
		return Password;
	}
	public void setPwd(String Password) {
		this.Password = Password;
	}
	public String getDate() {
		return RigisterDate;
	}
	public void setDate(String RigisterDate) {
		this.RigisterDate = RigisterDate;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
}
