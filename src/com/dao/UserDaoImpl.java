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

	
	public boolean question(User user) {
		boolean flag = false;
		DBconn.init();
		if(!(user.getQuestion().equals("")||user.getText().equals(""))){
		int i =DBconn.addUpdDel("insert into messege(Question,Text,Date) " +
				"values('"+user.getQuestion()+"','"+user.getText()+"','"+user.getDate2()+"')");
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
					//user.setID(rs.getInt("UserID"));
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
    
}

