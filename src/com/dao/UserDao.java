package com.dao;

import java.util.List;
 
import com.entity.User;
 
public interface UserDao {
	public User login(String Nickname,String Password);//��¼
	public boolean register(User user);//ע��
	public List<User> getUserAll();//�����û���Ϣ����
	public boolean delete(int UserID) ;//����idɾ���û�
	public boolean update(int UserID,String Nickname, String Password,String RigisterDate, String Email) ;//�����û���Ϣ
	public boolean question(User user);//����
	public List<User> getQuestionAll(int limit);//��ȡȫ������
	public int getQuestioncount();//��ȡ�����������ڷ�ҳ����
	public List<User> getMyQuestion(String Nickname);//��ȡ�ҵ�����
	public boolean AddScore(User user);
	public boolean deleteq(int QID);//ɾ������
	public User ADlogin(String Nickname,String Password);//����Ա��¼
	public boolean respond (User user);//�ظ�
	public List<User> getReplyAll(int QID);//��ȡȫ���ظ�
	public User getAll1(User user);//��ȡ��ս����Ϣ
	public List<User> getUserAll1(int limit);//��ȡÿ���û�ս��
	public int getAll1count();//��ȡս���������ڷ�ҳ����
	public boolean modifyM(int UserID,String Email);//�޸���Ϣ
	public boolean modifyP(int UserID,String Pwd);//�޸�����
	public List<User> getScore(int UserID,int limit);
	public int getScorecount(int UserID);
	public  List<User> rules();
	public  List<User> rulest();
	public boolean changerules(int each1);
	public boolean changerulest(int Startstep,int Endstep,int eachS);

}