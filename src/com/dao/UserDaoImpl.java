package com.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import com.entity.User;
import com.util.DBconn;
 
public class UserDaoImpl implements UserDao{
	
	public boolean register(User user) {
		boolean flag = false;
		DBconn.init();
		if(!(user.getName().equals("")||user.getPwd().equals("")||user.getEmail().equals(""))){
		int i =DBconn.addUpdDel("insert into user(Nickname,Password,RegisterDate,Email) " +
				"values('"+user.getName()+"','"+user.getPwd()+"','"+user.getDate()+"','"+user.getEmail()+"')");
		if(i>0){
			flag = true;
		}
		}
		DBconn.closeConn();
		return flag;
	}
    public User login(String Nickname, String Password) {
//		boolean flag = false;
		User user = new User();
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from user where Nickname='"+Nickname+"' and Password='"+Password+"'");
				System.out.println(rs);
				if(rs.next()){
					System.out.println(111);
					do {
					if(rs.getString("Nickname").equals(Nickname) && rs.getString("Password").equals(Password)){
//						flag = true;
						user.setID(rs.getInt("UserID"));
						user.setName(rs.getString("Nickname"));
						user.setPwd(rs.getString("Password"));
						user.setDate(rs.getString("RegisterDate"));
						user.setEmail(rs.getString("Email"));
					}	
					}while(rs.next());
				}
				else {user=null;}
				DBconn.closeConn(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<User> getUserAll() {
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from user");
			while(rs.next()){
				User user = new User();
				user.setID(rs.getInt("UserID"));
				user.setName(rs.getString("Nickname"));
				user.setPwd(rs.getString("Password"));
				user.setDate(rs.getString("RegisterDate"));
				user.setEmail(rs.getString("Email"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean update(int UserID,String Nickname, String Password,String RegisterDate, String Email) {
		boolean flag = false;
		DBconn.init();
		String sql ="update user set Nickname ='"+Nickname
				+"' , Password ='"+Password
				+"' , RegisterDate ='"+RegisterDate
				+"' , Email ='"+Email
				+"' where UserID = "+UserID;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public boolean delete(int UserID) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete from user where UserID="+UserID;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}

	
	public boolean deleteq(int QID) {
		boolean flag = false;
		DBconn.init();
		String sql = "delete from messege where QID="+QID;
		int i =DBconn.addUpdDel(sql);
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	
	public boolean question(User user) {
		boolean flag = false;
		DBconn.init();
		if(!(user.getQuestion().equals("")||user.getText().equals(""))){
		int i =DBconn.addUpdDel("insert into messege(QID,Nickname,Question,Text,Date) " +
				"values('"+user.getQID()+"','"+user.getName()+"','"+user.getQuestion()+"','"+user.getText()+"','"+user.getDate2()+"')");
		if(i>0){
			flag = true;
		}
		}
		DBconn.closeConn();
		return flag;
	}
	
	public List<User> getQuestionAll() {
			List<User> list = new ArrayList<User>();
	    	try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from messege");
				while(rs.next()){
					User user = new User();
					user.setQID(rs.getInt("QID"));
					user.setName(rs.getString("Nickname"));
					user.setQuestion(rs.getString("Question"));
					user.setText(rs.getString("Text"));
					user.setDate2(rs.getString("Date"));
					list.add(user);
				}
				DBconn.closeConn();
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return null;
	}
	public boolean AddScore(User user) {
		boolean flag = false;
		DBconn.init();
		int i =DBconn.addUpdDel("insert into score(UserID,Time,WorL,Date,Step) " +
				"values('"+user.getID()+"','"+user.getTime()+"','"+user.getWorL()+"','"+user.getGameDate()+"','"+user.getStep()+"')");
		if(i>0){
			flag = true;
		}
		DBconn.closeConn();
		return flag;
	}
	public User ADlogin(String name, String pwd) {
//		boolean flag = false;
		User user = new User();
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from admin1 where ADname='"+name+"' and ADpassword='"+pwd+"'");
				System.out.println(rs);
				if(rs.next()){
					do {
					if(rs.getString("ADname").equals(name) && rs.getString("ADpassword").equals(pwd)){
//						flag = true;
						user.setADID(rs.getInt("ADID"));
						user.setADName(rs.getString("ADname"));
						user.setADPwd(rs.getString("ADpassword"));
						user.setADEmail(rs.getString("ADemail"));
					}
					}while(rs.next());
				}
				else {user=null;}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public boolean respond(User user) {
		boolean flag = false;
		DBconn.init();
		if(!(user.getAnswer().equals(""))){
		int i =DBconn.addUpdDel("insert into respond(QID,RID,Nickname,Answer,RDate) " +
				"values('"+user.getQID()+"','"+user.getRID()+"','"+user.getName()+"','"+user.getAnswer()+"','"+user.getDate2()+"')");
		if(i>0){
			flag = true;
		}
		}
		DBconn.closeConn();
		return flag;
	}
    



public List<User> getReplyAll(int QID) {
	List<User> list = new ArrayList<User>(QID);
	try {
	    DBconn.init();
		ResultSet rs = DBconn.selectSql("select messege.Question,respond.RID,respond.Nickname,respond.Answer,respond.RDate from respond,messege where respond.QID=messege.QID and respond.QID='"+QID+"'");
		System.out.println("DAO"+QID);
		while(rs.next()){
			User user = new User();
			user.setQuestion(rs.getString("Question"));
			user.setRID(rs.getInt("RID"));
			user.setName(rs.getString("Nickname"));
			user.setAnswer(rs.getString("Answer"));
			user.setDate2(rs.getString("RDate"));
			list.add(user);
		}
		DBconn.closeConn();
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public User getAll1(User user) {
//	boolean flag = false;
	int id = user.getID();
	try {
		    DBconn.init();
			ResultSet rs = DBconn.selectSql("select * from all1_order where UserID='"+id+"'");
//			System.out.println(rs);
			if(rs.next()){
				System.out.println(111);
//					flag = true;
					user.setRankname(rs.getString("Rankname"));
					user.setSC(rs.getInt("SC"));
					user.setCountL(rs.getInt("CountL"));
					user.setCountW(rs.getInt("CountW"));
					user.setMyrank(rs.getInt("ranking"));
			}
			DBconn.closeConn(); 
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return user;
}
public List<User> getUserAll1(int limit){
	List<User> list = new ArrayList<User>();
	try {
	    DBconn.init();
		ResultSet rs = DBconn.selectSql("select * from all1_order limit "+limit+",5");
		while(rs.next()){
			User user = new User();
			user.setMyrank(rs.getInt("ranking"));
			user.setName(rs.getString("Nickname"));
			user.setRankname(rs.getString("Rankname"));
			user.setSC(rs.getInt("SC"));
			user.setCountW(rs.getInt("CountW"));
			user.setCountL(rs.getInt("CountL"));
			list.add(user);
		}
		DBconn.closeConn();
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}

public int getAll1count() {
	int i=0;
	try {
	    DBconn.init();
		ResultSet rs = DBconn.selectSql("call all1_count");
		if(rs.next()){
			i=rs.getInt("num");
		}
		DBconn.closeConn();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return i;	
}
public boolean modifyM(int UserID,String Email) {
	boolean flag = false;
	DBconn.init();
	String sql ="update user set Email ='"+Email
			+"' where UserID = "+UserID;
	int i =DBconn.addUpdDel(sql);
	if(i>0){
		flag = true;
	}
	DBconn.closeConn();
	return flag;
}
public boolean modifyP(int UserID,String Password) {
	boolean flag = false;
	DBconn.init();
	String sql ="update user set Password ='"+Password
			+"' where UserID = "+UserID;
	int i =DBconn.addUpdDel(sql);
	if(i>0){
		flag = true;
	}
	DBconn.closeConn();
	return flag;
}

public List<User> getMyQuestion(String Nickname) {
		List<User> list = new ArrayList<User>();
    	try {
		    DBconn.init();
		    
			ResultSet rs = DBconn.selectSql("select * from messege where Nickname='"+Nickname+"'");
			while(rs.next()){
				User user = new User();
				user.setQID(rs.getInt("QID"));
				user.setQuestion(rs.getString("Question"));
				user.setText(rs.getString("Text"));
				user.setDate2(rs.getString("Date"));
				list.add(user);
			}
			DBconn.closeConn();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return null;
}

public List<User> getScore(int UserID,int limit) {
	List<User> list = new ArrayList<User>();
	try {
	    DBconn.init();
		ResultSet rs = DBconn.selectSql("select * from score_point where UserID="+ UserID +" order by Date desc limit "+limit+",5");
		while(rs.next()){
			User user = new User();
			user.setGameDate(rs.getString("Date"));
			String WorL = rs.getString("WorL");
			System.out.println(WorL.equals("L")==true);
			if(WorL.equals("L")==true) {
				user.setWorL("¸º");
			}
			else {
				user.setWorL("Ê¤");
			}
//			user.setWorL(rs.getString("WorL"));
			user.setStep(rs.getInt("Step"));
			user.setTime(rs.getDouble("Time"));
			user.setScore(rs.getInt("Score"));
			list.add(user);
		}
		DBconn.closeConn();
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
}
public int getScorecount(int UserID) {
	int i=0;
	try {
	    DBconn.init();
		ResultSet rs = DBconn.selectSql("select count(*) num from score_point where UserID ="+UserID);
		if(rs.next()){
			i=rs.getInt("num");
		}
		DBconn.closeConn();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return i;	
}
}

