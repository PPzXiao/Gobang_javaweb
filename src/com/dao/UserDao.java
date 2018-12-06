package com.dao;

import java.util.List;
 
import com.entity.User;
 
public interface UserDao {
	public User login(String Nickname,String Password);//登录
	public boolean register(User user);//注册
	public List<User> getUserAll();//返回用户信息集合
	public boolean delete(int UserID) ;//根据id删除用户
	public boolean update(int UserID,String Nickname, String Password,String RigisterDate, String Email) ;//更新用户信息
	public boolean question(User user);//留言
	public List<User> getQuestionAll(int limit);//获取全部留言
	public int getQuestioncount();//获取留言总数用于分页功能
	public List<User> getMyQuestion(String Nickname);//获取我的留言
	public boolean AddScore(User user);
	public boolean deleteq(int QID);//删除问题
	public User ADlogin(String Nickname,String Password);//管理员登录
	public boolean respond (User user);//回复
	public List<User> getReplyAll(int QID);//获取全部回复
	public User getAll1(User user);//获取总战绩信息
	public List<User> getUserAll1(int limit);//获取每个用户战绩
	public int getAll1count();//获取战绩总数用于分页功能
	public boolean modifyM(int UserID,String Email);//修改信息
	public boolean modifyP(int UserID,String Pwd);//修改密码
	public List<User> getScore(int UserID,int limit);
	public int getScorecount(int UserID);
	public  List<User> rules();
	public  List<User> rulest();
	public boolean changerules(int each1);
	public boolean changerulest(int Startstep,int Endstep,int eachS);

}