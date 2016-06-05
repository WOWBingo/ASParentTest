package com.footmark.dao;

import java.util.List;

import com.footmark.model.AtdWall;
import com.footmark.model.User;

public interface AtdWallDAO {

	/**
	 * 1������ǽ
	 */
	public boolean createAtdWall(String atdwallname,User user, double x,double y);
	
	/**
	 * 2���޸�ǽ��Ϣ
	 */
	public boolean updateAtdWall(Long wallid, int wallStatus);
	
	/**
	 * 3��ͨ���û��������û�����������ǽ
	 * username �û���
	 */
	public List<AtdWall> findAtdWallsByUserName(String username);
	
	/**
	 * 4��ͨ��id��ȡǽ��Ϣ
	 * wallid ǽid
	 */
	public AtdWall findAtdWallByAtdWallid(Long wallid);
	
	/**
	 * 5��ͨ��������Ҹ�����ǽ
	 *  x ���ȣ� y γ�ȣ�
	 */
	public List<AtdWall> findAtdAtdWallsByXY( double x,double y);
	
	public boolean deleteAtdWall(Long wallid);
}
