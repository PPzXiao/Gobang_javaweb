package com.dao;

import java.util.List;
 
import com.entity.User;
 
public interface UserDao {
	public User login(String Nickname,String Password);//登录
	public boolean register(User user);//注册
	public List<User> getUserAll();//返回用户信息集合
	public User getUser();
	public boolean delete(int UserID) ;//根据id删除用户
	public boolean update(int UserID,String Nickname, String Password,String RigisterDate, String Email) ;//更新用户信息
}