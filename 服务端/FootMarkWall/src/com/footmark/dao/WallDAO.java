package com.footmark.dao;

import java.util.List;

import com.footmark.model.User;
import com.footmark.model.Wall;

public interface WallDAO {
	/**
	 * 1������ǽ
	 *wallid ǽid; wallName ǽ����wallSignature ǩ����creator �����ߣ�wallType ���ͣ� x ���ȣ� y γ�ȣ� wallImage ����ͼƬ��ַ
	 */
	public boolean createWall(Long wallid,String wallName,String wallSignature,User user,Integer wallType, double x,double y,String wallImage,String walladress);
	
	/**
	 * 2���޸�ǽ��Ϣ
	 * wallid ǽid��wallName ǽ����wallSignature ǩ����creator �����ߣ�wallType ���ͣ�wallStatus ǽ״̬�� wallImage ����ͼƬ��ַ
	 */
	public boolean updateWall(Long wallid, String wallName,String wallSignature,String wallImage,Integer wallType,int wallStatus);
	
	/**
	 * 3��ͨ���û��������û�����������ǽ
	 * username �û���
	 */
	public List<Wall> findWallsByUserName(String username);
	
	/**
	 * 4��ͨ��id��ȡǽ��Ϣ
	 * wallid ǽid
	 */
	public Wall findWallByWallid(Long wallid);
	
	/**
	 * 5��ͨ��������Ҹ�����ǽ
	 *  x ���ȣ� y γ�ȣ�
	 */
	public List<Wall> findWallsByXY( double x,double y);
	
	public boolean deleteWall(Long wallid);
	
	public boolean updateWallUser(Long wallid, User user);


}
