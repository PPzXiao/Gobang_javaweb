package com.entity;

public class User {
   
	private int UserID;
    private String Nickname;
    private String Password;
    private String RigisterDate;
    private String Email;
    
    private String Question;
    private String Text;
    private String Date;
    
    private double Time;
    private String WorL;
    private int Step;
    private String GameDate;
    
    private int QID;
    
    private int ADID;
    private String ADname;
    private String ADpassword;
    private String ADemail;
	public int getADID() {
		return ADID;
	}
	public void setADID(int ADID) {
		this.ADID = ADID;
	}
	public String getADName() {
		return ADname;
	}
	public void setADName(String ADname) {
		this.ADname = ADname;
	}
	public String getADPwd() {
		return ADpassword;
	}
	public void setADPwd(String ADpassword) {
		this.ADpassword = ADpassword;
	}
	public String getADEmail() {
		return ADemail;
	}
	public void setADEmail(String ADemail) {
		this.ADemail = ADemail;
	}
	
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
	
	public void setTime (double Time) {
		this.Time = Time;
    }
    
    public double getTime(){
    	return Time;
    }
    public void setWorL (String WorL) {
		this.WorL = WorL;
    }
    public String getWorL(){
    	return WorL;
    }
    public void setStep (int Step) {
		this.Step = Step;
    }
    public int getStep(){
    	return Step;
    }
    public void setGameDate (String GameDate) {
		this.GameDate = GameDate;
    }
    public String getGameDate(){
    	return GameDate;
    }
    
    public int getQID() {
    	return QID;
    }
    public void setQID(int QID) {
    	this.QID = QID;
    }
    	
    
    
}
