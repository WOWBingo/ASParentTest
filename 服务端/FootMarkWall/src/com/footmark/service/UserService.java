package com.footmark.service;

import javax.ws.rs.PathParam;

import com.footmark.tools.ResultObject;


public interface UserService {

	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";
	/**
	 * 1.�û�ע��
	 * ������userName �û���;  password ���� ;  trueName  ��ʵ����    
	 */
	public ResultObject register(String userName, String password, String trueName);
	
	/**
	 * 2.�û���¼ 
	 * ������userName �û���; password ����
	 */
	public ResultObject Login(String userName, String password);
	
	/**
	 * 3.�����û�����ѯ�û�
	 *  ������ username  �û���
	 */
	public ResultObject findUserByUserName(String userName);
	
	/**
	 * 4.�޸��û���Ϣ
	 * ������userName �û���; password ����;  trueName ��ʵ����;  tel  �绰; photoURL ͷ���ַ;  userStatus  �û�״̬
	 */
	public ResultObject updateUserTrue(String userName,
			String trueName);
	
	public ResultObject updateUserTel(String userName,String tel);
	public ResultObject updateUserAge(String userName,int age);
	public ResultObject updateUserSex(String userName,String sex);
	public ResultObject updateUserPhotoURL(String userName, String photourl);
	
	/**
	 * 5.�޸��û�����
	 * ������userName �û���; password ����  
	 */
	public ResultObject updateUserPwd(String userName, String password);
}
