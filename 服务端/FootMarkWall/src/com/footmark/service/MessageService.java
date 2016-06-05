package com.footmark.service;

import com.footmark.tools.ResultObject;

public interface MessageService {

	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";
    
    /**
	 * ����
	 * �����ߣ�����ǽ�����ݣ����ͣ�״̬��ͼƬ
	 */
	public ResultObject createMessage(long msgid,String username, Long wallid,String msgContent,String msgImage);
	
	/**
	 * �޸�
	 * ID�����ݣ����ͣ�״̬��ͼƬ
	 */
	public ResultObject updateMessage(long msgid,String msgContent,Integer msgType,Integer msgStatus,String msgImage);
	
	/**
	 * �޸�״̬
	 * ID��״̬
	 */
	public ResultObject updateMessageStatus(long msgid,Integer msgStatus);
	
	/**
	 * �޸�����
	 * ID�����ͣ�
	 */
	public ResultObject updateMessageType(long msgid,Integer msgType);
	
	/**
	 * ͨ��ǽ��ѯ
	 * ǽID��
	 */
	public ResultObject findAllMsgByWallid(long wallid);
	
	/**
	 * ͨ���û�����ѯ����
	 * �û�����
	 */
	public ResultObject findAllUserMsgByUsername(String username);
	
	/**
	 * ͨ���û�����״̬��ѯ
	 * �û�����״̬
	 */
	public ResultObject findMsgByUsernameAndStatus(String username,Integer msgStatus);
	
	/**
	 * ͨ���û��������Ͳ�ѯ
	 * �û���������
	 */
	public ResultObject findMsgByUsernameAndType(String username,Integer msgType);
	
	/**
	 * ͨ����ϢID��ѯ��Ϣ��ϸ����
	 * id
	 */
	public ResultObject findMsgByMsgid(long msgid);
}
