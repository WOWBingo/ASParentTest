package com.footmark.service;

import javax.ws.rs.PathParam;

import com.footmark.tools.ResultObject;

public interface AtdService {

	public static final String KSUCCESS = "1";
    public static final String KFAIL = "0";
    
    /**
	 * ����
	 * �����ߣ�����ǽ�����ݣ����ͣ�״̬��ͼƬ
	 */
	public ResultObject atd(String username, Long atdwallid,String atdinfo,String atdidentifier);
	
	public ResultObject findAllAtdByAtdWallid(Long wallid);
}
