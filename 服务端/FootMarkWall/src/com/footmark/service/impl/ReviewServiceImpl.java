package com.footmark.service.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.footmark.dao.ReviewDAO;
import com.footmark.dao.UserDAO;
import com.footmark.dao.impl.ReviewDAOImpl;
import com.footmark.dao.impl.UserDAOImpl;
import com.footmark.model.Review;
import com.footmark.model.User;
import com.footmark.service.ReviewService;
import com.footmark.tools.ResultObject;

@Path("reviewservice")
public class ReviewServiceImpl implements ReviewService {
	
	ReviewDAO reviewDAO = new ReviewDAOImpl();
	UserDAO userDAO = new UserDAOImpl();

	/**
	 * ��������
	 * ��Ϣid�������û����������û������������ݣ�
	 */
	@Override
	@GET
	@Path("createreview/{msgid},{fromUserName},{toUserName},{revContent}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject createReview(@PathParam("msgid")long msgid,@PathParam("fromUserName") String fromUserName,
			@PathParam("toUserName")String toUserName,@PathParam("revContent") String revContent) {
		boolean result = false;
		User fromuser = userDAO.findUserByUserName(fromUserName);
		User touser = userDAO.findUserByUserName(toUserName);
		if (fromuser != null && touser != null) {
			result = reviewDAO.createReview(msgid, fromUserName, toUserName, revContent);
			if (result) {
				return new ResultObject(KSUCCESS, "success");
			}
		}
		return new ResultObject(KFAIL, "fial");
	}

	/**
	 * �޸�����״̬
	 * ����id��״̬��
	 */
	@Override
	@GET
	@Path("changereviewstatus/{revid},{revStatus}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateReviewStatus(@PathParam("revid")long revid, @PathParam("revStatus")Integer revStatus) {
		boolean result = reviewDAO.updateReviewStatus(revid, revStatus);
		if (result) {
			return new ResultObject(KSUCCESS,"success");
		}
		return new ResultObject(KFAIL,"fial");
	}

	/**
	 * ͨ����ϢID������������
	 * ��Ϣid��
	 */
	@Override
	@GET
	@Path("findreviewbymsgid/{msgid}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findReviewByMsgid(@PathParam("msgid")long msgid) {
		List<Review> reviewsList = reviewDAO.findReviewByMsgid(msgid);
		if (reviewsList.size()!=0) {
			return new ResultObject(KSUCCESS,reviewsList);
		}
		return new ResultObject(KFAIL,null);
	}

	/**
	 * ͨ�������û�������������
	 * �û�����
	 */
	@Override
	@GET
	@Path("findreviewbyfromuser/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findReviewByFromUser(@PathParam("username")String username) {
		List<Review> reviewsList = reviewDAO.findReviewByFromUser(username);
		if (reviewsList.size()!=0) {
			return new ResultObject(KSUCCESS,reviewsList);
		}
		return new ResultObject(KFAIL,null);
	}

	/**
	 * ͨ�������û�������������
	 * �û�����
	 */
	@Override
	@GET
	@Path("findreviewbytouser/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findReviewByToUser(@PathParam("username")String username) {
		List<Review> reviewsList = reviewDAO.findReviewByToUser(username);
		if (reviewsList.size()!=0) {
			return new ResultObject(KSUCCESS,reviewsList);
		}
		return new ResultObject(KFAIL,null);
	}

}
