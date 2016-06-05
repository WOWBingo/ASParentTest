package com.footmark.service;

import javax.ws.rs.PathParam;

import com.footmark.tools.ResultObject;

public interface CollectService {
	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";

    /**
	 * �ղ�
	 * �û�����ǽID
	 */
	public ResultObject collectWall(String username,long wallid);
	
	
	/**
	 * �����û�������ȫ���ղ�
	 * �û���
	 */
	public ResultObject findAllCollectByUsername(String username);
	
	
/////////////////////////////////////////////////////////////////////////////
	/**
	 * �ղ�
	 * �û�������ϢID
	 */
	public ResultObject collectMessage(String username,long msgid);
	
	
	/**
	 * �����û�������ȫ���ղ�
	 * �û���
	 */
	public ResultObject findAllCollectMessageByUsername(String username);
	
	
	public ResultObject findAllCollectWallByUsername(String username);
	
    
}
