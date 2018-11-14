package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Admin;
import com.util.DBconn;

public class AdminDaoImpl implements AdminDao{
	
    public boolean login(String name, String pwd) {
		boolean flag = false;
		try {
			    DBconn.init();
				ResultSet rs = DBconn.selectSql("select * from admin1 where ADname='"+name+"' and ADpassword='"+pwd+"'");
				System.out.println(rs);
				while(rs.next()){
					if(rs.getString("ADname").equals(name) && rs.getString("ADpassword").equals(pwd)){
						flag = true;
					}
				}
				DBconn.closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
    
}