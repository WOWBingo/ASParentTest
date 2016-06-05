package com.footmark.dao;

import java.util.List;

import com.footmark.model.Review;

public interface ReviewDAO {
	
	/**
	 * ��������
	 * ��Ϣid�������û����������û������������ݣ�
	 */
	public boolean createReview(long msgid,String fromUserName,String toUserName,String revContent);
	
	/**
	 * �޸�����״̬
	 * ����id��״̬��
	 */
	public boolean updateReviewStatus(long revid,Integer revStatus);
	
	/**
	 * ͨ����ϢID������������
	 * ��Ϣid��
	 */
	public List<Review> findReviewByMsgid(long msgid);
	
	/**
	 * ͨ�������û�������������
	 * �û�����
	 */
	public List<Review> findReviewByFromUser(String username);
	
	/**
	 * ͨ�������û�������������
	 * �û�����
	 */
	public List<Review> findReviewByToUser(String username);
	
	
	
	
	
	
	
	
	
	
	
	
	

}
