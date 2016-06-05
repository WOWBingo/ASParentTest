package com.footmark.service;

import javax.ws.rs.PathParam;

import com.footmark.tools.ResultObject;

public interface AtdWallService {

	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";
	/**
	 * 1������ǽ
	 * Long wallid,wallName ǽ����wallSignature ǩ����creator �����ߣ�wallType ���ͣ� x ���ȣ� y γ�ȣ� wallImage ����ͼƬ��ַ
	 */
	public ResultObject createAtdWall(String wallName,String username, double x,double y);
	
	/**
	 * 2���޸�ǽ��Ϣ
	 * wallid ǽid��wallName ǽ����wallSignature ǩ����creator �����ߣ�wallType ���ͣ�wallStatus ǽ״̬�� wallImage ����ͼƬ��ַ
	 */
	public ResultObject updateAtdWall(Long wallid, int wallStatus);
	
	/**
	 * 3��ͨ���û��������û�����������ǽ
	 * username �û���
	 */
	public ResultObject findAtdWallsByUserName(String username);
	
	/**
	 * 4��ͨ��id��ȡǽ��Ϣ
	 * wallid ǽid
	 */
	public ResultObject findAtdWallByWallid(Long wallid);
	
	/**
	 * 5��ͨ��������Ҹ�����ǽ
	 *  x ���ȣ� y γ�ȣ�
	 */
	public ResultObject findAtdWallsByXY( double x,double y);
	
	public ResultObject deleteWall(Long wallid, String username) ;
}
