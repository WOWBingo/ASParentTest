package com.footmark.dao;

import com.footmark.model.User;

public interface UserDAO {

	/**
	 * 1.�û�ע��
	 * ������userName �û���;  password ���� ;  trueName  ��ʵ����    
	 */
	public boolean register(String userName, String password, String trueName);
	
	/**
	 * 2.�û���¼ 
	 * ������userName �û���; password ����
	 */
	public User Login(String userName, String password);
	
	/**
	 * 3.�����û�����ѯ�û�
	 *  ������ username  �û���
	 */
	public User findUserByUserName(String userName);
	
	/**
	 * 4.�޸��û���Ϣ
	 * ������userName �û���; password ����;  trueName ��ʵ����;  tel  �绰; photoURL ͷ���ַ;  userStatus  �û�״̬
	 */
	public boolean updateUser(String userName, String password,
			String trueName, String tel,String photoURL,int userStatus,int age,String sex);
	
	public boolean updateUser(User user);
	
	/**
	 * 5.�޸��û�����
	 * ������userName �û���; password ����  
	 */
	public boolean updateUserPwd(String userName, String password);
	

}
