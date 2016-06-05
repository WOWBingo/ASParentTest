package com.footmark.dao;

import java.util.List;

import com.footmark.model.Message;
import com.footmark.model.User;
import com.footmark.model.Wall;

public interface MessageDAO {
	/**
	 * ����
	 * �����ߣ�����ǽ�����ݣ����ͣ�״̬��ͼƬ
	 */
	public boolean createMessage(long msgid,User user, Wall wall,String msgContent,String msgImage);
	
	/**
	 * �޸�
	 * ID�����ݣ����ͣ�״̬��ͼƬ
	 */
	public boolean updateMessage(long msgid,String msgContent,Integer msgType,Integer msgStatus,String msgImage);
	
	/**
	 * �޸�״̬
	 * ID��״̬
	 */
	public boolean updateMessageStatus(long msgid,Integer msgStatus);
	
	/**
	 * �޸�����
	 * ID�����ͣ�
	 */
	public boolean updateMessageType(long msgid,Integer msgType);
	
	/**
	 * ͨ��ǽ��ѯ
	 * ǽID��
	 */
	public List<Message> findAllMsgByWallid(long wallid);
	
	/**
	 * ͨ���û�����ѯ����
	 * �û�����
	 */
	public List<Message> findAllUserMsgByUsername(String username);
	
	/**
	 * ͨ���û�����״̬��ѯ
	 * �û�����״̬
	 */
	public List<Message> findMsgByUsernameAndStatus(String username,Integer msgStatus);
	
	/**
	 * ͨ���û��������Ͳ�ѯ
	 * �û���������
	 */
	public List<Message> findMsgByUsernameAndType(String username,Integer msgType);
	
	/**
	 * ͨ����ϢID��ѯ��Ϣ��ϸ����
	 * id
	 */
	public Message findMsgByMsgid(long msgid);
	
	
	
	public boolean deleteMsgByWallid(Long wallid) ;
	
	public boolean deleteMsgByWallidAndUser(Long wallid,String username);
	
	
	
	
	
	
	
	
	
	
	
}
