package com.footmark.service;

import com.footmark.tools.ResultObject;

public interface ReviewService {

	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";
    
	/**
	 * ��������
	 * ��Ϣid�������û����������û������������ݣ�
	 */
	public ResultObject createReview(long msgid,String fromUserName,String toUserName,String revContent);
	
	/**
	 * �޸�����״̬
	 * ����id��״̬��
	 */
	public ResultObject updateReviewStatus(long revid,Integer revStatus);
	
	/**
	 * ͨ����ϢID������������
	 * ��Ϣid��
	 */
	public ResultObject findReviewByMsgid(long msgid);
	
	/**
	 * ͨ�������û�������������
	 * �û�����
	 */
	public ResultObject findReviewByFromUser(String username);
	
	/**
	 * ͨ�������û�������������
	 * �û�����
	 */
	public ResultObject findReviewByToUser(String username);
}
