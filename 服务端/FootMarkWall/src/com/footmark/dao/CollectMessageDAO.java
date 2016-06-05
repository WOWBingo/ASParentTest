package com.footmark.dao;

import java.util.List;

import com.footmark.model.CollectMessage;

public interface CollectMessageDAO {
	
	/**
	 * �ղ�
	 * �û�������ϢID
	 */
	public boolean collectMessage(String username,long msgid);
	
	/**
	 * ȡ���ղ�
	 * �û�������ϢID
	 */
	public boolean deleteCollectMessage(CollectMessage collectMessage);
	
	/**
	 * �����û�������ȫ���ղ�
	 * �û���
	 */
	public List<CollectMessage> findAllCollectMessageByUsername(String username);
	
	/**
	 * �����û�����id�����ղ�
	 * �û���
	 */
	public CollectMessage findCollectMessageByUsername(String username,long msgid);

}
