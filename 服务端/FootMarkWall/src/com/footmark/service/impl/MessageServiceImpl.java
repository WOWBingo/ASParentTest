package com.footmark.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.footmark.dao.MessageDAO;
import com.footmark.dao.UserDAO;
import com.footmark.dao.WallDAO;
import com.footmark.dao.impl.MessageDAOImpl;
import com.footmark.dao.impl.UserDAOImpl;
import com.footmark.dao.impl.WallDAOImpl;
import com.footmark.model.Message;
import com.footmark.model.User;
import com.footmark.model.Wall;
import com.footmark.service.MessageService;
import com.footmark.tools.ResultObject;

@Path("msgservice")
public class MessageServiceImpl implements MessageService {
	
	MessageDAO messageDAO = new MessageDAOImpl();
	UserDAO userDAO = new UserDAOImpl();
	WallDAO wallDAO = new WallDAOImpl();

	/**
	 * ����
	 * �����ߣ�����ǽ�����ݣ����ͣ�״̬��ͼƬ
	 */
	@Override
	@GET
	@Path("/createmsg")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject createMessage(
			@QueryParam("msgid")long msgid,
			@QueryParam("username")String username,
			@QueryParam("wallid")Long wallid,
			@QueryParam("msgContent")String msgContent,
			@QueryParam("msgImage")String msgImage) {
		boolean result = false;
		User user = userDAO.findUserByUserName(username);
		Wall wall = wallDAO.findWallByWallid(wallid);
		if (user != null && wall != null) {
			result = messageDAO.createMessage(msgid,user, wall, msgContent, msgImage);
			if (result) {
				return new ResultObject(KSUCCESS, "success");
			}
		}
		return new ResultObject(KFAIL, "fial");
	}

	/**
	 * �޸�
	 * ID�����ݣ����ͣ�״̬��ͼƬ
	 */
	@Override
	@GET
	@Path("updatemsg/{msgid},{msgContent},{msgType},{msgStatus},{msgImage}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateMessage(@PathParam("msgid")long msgid,
			@PathParam("msgContent")String msgContent,
			@PathParam("msgType")Integer msgType,
			@PathParam("msgStatus")Integer msgStatus,
			@PathParam("msgImage")String msgImage) {
		boolean result = messageDAO.updateMessage(msgid, msgContent, msgType, msgStatus, msgImage);
		if (result) {
			return new ResultObject(KSUCCESS,"success");
		}
		return new ResultObject(KFAIL,"fial");
	}

	/**
	 * �޸�״̬
	 * ID��״̬
	 */
	@Override
	@GET
	@Path("updatemsgstatus/{msgid},{msgStatus}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateMessageStatus(@PathParam("msgid")long msgid,@PathParam("msgStatus") Integer msgStatus) {
		boolean result = messageDAO.updateMessageStatus(msgid, msgStatus);
		if (result) {
			return new ResultObject(KSUCCESS,"success");
		}
		return new ResultObject(KFAIL,"fial");
	}

	/**
	 * �޸�����
	 * ID�����ͣ�
	 */
	@Override
	@GET
	@Path("updatemsgtype/{msgid},{msgType}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateMessageType(@PathParam("msgid")long msgid,@PathParam("msgType") Integer msgType) {
		boolean result = messageDAO.updateMessageType(msgid, msgType);
		if (result) {
			return new ResultObject(KSUCCESS,"success");
		}
		return new ResultObject(KFAIL,"fial");
	}

	/**
	 * ͨ��ǽ��ѯ
	 * ǽID��
	 */
	@Override
	@GET
	@Path("findallmsgbywallid/{wallid}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findAllMsgByWallid(@PathParam("wallid")long wallid) {
		List<Message> msgList = messageDAO.findAllMsgByWallid(wallid);
		if (msgList.size()!=0) {
			return new ResultObject(KSUCCESS,msgList);
		}
		return new ResultObject(KFAIL,null);
	}

	/**
	 * ͨ���û�����ѯ����
	 * �û�����
	 */
	@Override
	@GET
	@Path("findallmsgbyusername/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findAllUserMsgByUsername(@PathParam("username")String username) {
		List<Message> msgList = messageDAO.findAllUserMsgByUsername(username);
		if (msgList.size()!=0) {
			return new ResultObject(KSUCCESS,msgList);
		}
		return new ResultObject(KFAIL,null);
	}

	/**
	 * ͨ���û�����״̬��ѯ
	 * �û�����״̬
	 */
	@Override
	@GET
	@Path("findallmsgbystatus/{username},{msgstatus}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findMsgByUsernameAndStatus(@PathParam("username")String username,
			@PathParam("msgStatus")Integer msgStatus) {
		List<Message> msgList = messageDAO.findMsgByUsernameAndStatus(username, msgStatus);
		if (msgList.size()!=0) {
			return new ResultObject(KSUCCESS,msgList);
		}
		return new ResultObject(KFAIL,null);
	}

	/**
	 * ͨ���û��������Ͳ�ѯ
	 * �û���������
	 */
	@Override
	@GET
	@Path("findallmsgbytype/{username},{msgType}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findMsgByUsernameAndType(@PathParam("username")String username,
			@PathParam("msgType")Integer msgType) {
		List<Message> msgList = messageDAO.findMsgByUsernameAndType(username, msgType);
		if (msgList.size()!=0) {
			return new ResultObject(KSUCCESS,msgList);
		}
		return new ResultObject(KFAIL,null);
	}
	
	/**
	 * ͨ����ϢID��ѯ��Ϣ��ϸ����
	 * id
	 */
	@Override
	@GET
	@Path("findmsgbymsgid/{msgid}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findMsgByMsgid(@PathParam("msgid")long msgid) {
		Message message = messageDAO.findMsgByMsgid(msgid);
		if (message!=null) {
			return new ResultObject(KSUCCESS,message);
		}
		return new ResultObject(KFAIL,null);
	}

}
