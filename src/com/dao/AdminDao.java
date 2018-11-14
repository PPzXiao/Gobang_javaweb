package com.dao;

import java.util.List;
 
import com.entity.Admin;;
 
public interface AdminDao {
	public boolean login(String name,String pwd);//登录
//	public boolean register(User user);//注册
//	public List<User> getUserAll();//返回用户信息集合
//	public boolean delete(int UserID) ;//根据id删除用户
//	public boolean update(int UserID,String Nickname, String Password,String RigisterDate, String Email) ;//更新用户信息
}
