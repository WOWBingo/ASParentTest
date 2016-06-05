package com.footmark.dao;

import java.util.List;

import com.footmark.model.CollectWall;
import com.footmark.model.User;
import com.footmark.model.Wall;

public interface CollectWallDAO {
	
	/**
	 * �ղ�
	 * �û�����ǽID
	 */
	public boolean collectWall(String username,Long wallid);
	
	/**
	 * ȡ���ղ�
	 * �û�����ǽID
	 */
	public boolean deleteCollectWall(CollectWall collectWall);
	
	/**
	 * �����û�������ȫ���ղ�
	 * �û���
	 */
	public List<CollectWall> findAllCollectWallByUsername(String username);
	
	/**
	 * �����û���ǽid�鿴�Ƿ��ղ�
	 * �û���
	 */
	public CollectWall findCollectWallByUsername(String username,long wallid);

}
