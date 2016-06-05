package com.footmark.service;

import javax.ws.rs.PathParam;

import com.footmark.tools.ResultObject;

public interface WallService {

	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";
	/**
	 * 1������ǽ
	 * Long wallid,wallName ǽ����wallSignature ǩ����creator �����ߣ�wallType ���ͣ� x ���ȣ� y γ�ȣ� wallImage ����ͼƬ��ַ
	 */
	public ResultObject createWall(Long wallid,String wallName,String wallSignature,String username,Integer wallType, double x,double y,String wallImage,String walladress);
	
	/**
	 * 2���޸�ǽ��Ϣ
	 * wallid ǽid��wallName ǽ����wallSignature ǩ����creator �����ߣ�wallType ���ͣ�wallStatus ǽ״̬�� wallImage ����ͼƬ��ַ
	 */
	public ResultObject updateWall(Long wallid, String wallName,String wallSignature,String wallImage,Integer wallType,int wallStatus);
	
	/**
	 * 3��ͨ���û��������û�����������ǽ
	 * username �û���
	 */
	public ResultObject findWallsByUserName(String username);
	
	/**
	 * 4��ͨ��id��ȡǽ��Ϣ
	 * wallid ǽid
	 */
	public ResultObject findWallByWallid(Long wallid);
	
	/**
	 * 5��ͨ��������Ҹ�����ǽ
	 *  x ���ȣ� y γ�ȣ�
	 */
	public ResultObject findWallsByXY( double x,double y);
	
	public ResultObject deleteWall(Long wallid, String wallName);
	
}
