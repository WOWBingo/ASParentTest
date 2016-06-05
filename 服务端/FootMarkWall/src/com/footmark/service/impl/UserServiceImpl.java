package com.footmark.service.impl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.footmark.dao.UserDAO;
import com.footmark.dao.impl.UserDAOImpl;
import com.footmark.model.User;
import com.footmark.service.UserService;
import com.footmark.tools.ResultObject;

@Path("userservice")
public class UserServiceImpl implements UserService {
	
	UserDAO userDAO = new UserDAOImpl();

	/**
	 * 1.�û�ע��
	 * ������userName �û���;  password ���� ;  trueName  ��ʵ����    
	 */
	@Override
	@GET
	@Path("register/{userName},{password},{trueName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject register(@PathParam("userName")String userName, @PathParam("password")String password, @PathParam("trueName")String trueName) {
		boolean result = userDAO.register(userName, password, trueName);
		if (result) {
			return new ResultObject(KSUCCESS,"success");
		}
		return new ResultObject(KFAIL,"fail");
	}

	/**
	 * 2.�û���¼ 
	 * ������userName �û���; password ����
	 */
	@Override
	@GET
	@Path("login/{userName},{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject Login(@PathParam("userName")String userName,  @PathParam("password")String password) {
		User user = userDAO.Login(userName, password);
		if (user!=null) {
			return new ResultObject(KSUCCESS,user);
		}
		return new ResultObject(KFAIL,user);
	}

	/**
	 * 3.�����û�����ѯ�û�
	 *  ������ username  �û���
	 */
	@Override
	@GET
	@Path("finduserbyname/{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject findUserByUserName(@PathParam("userName")String userName) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null) {
			return new ResultObject(KSUCCESS,user);
		}
		return new ResultObject(KFAIL,user);
	}

	/**
	 * 4.�޸��û���Ϣ
	 * ������userName �û���; password ����;  trueName ��ʵ����;  tel  �绰; photoURL ͷ���ַ;  userStatus  �û�״̬
	 */
	@Override
	@GET
	@Path("updatetruename/{userName},{trueName}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateUserTrue(@PathParam("userName")String userName, @PathParam("trueName")String trueName) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null) {
			user.setTruename(trueName);
			boolean result = userDAO.updateUser(user);
			if (result) {
				return new ResultObject(KSUCCESS,"success");
			}
		}
		
		return new ResultObject(KFAIL,"fial");
	}

	@Override
	@GET
	@Path("updatetel/{userName},{tel}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateUserTel(@PathParam("userName")String userName,@PathParam("tel") String tel) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null) {
			user.setTel(tel);
			boolean result = userDAO.updateUser(user);
			if (result) {
				return new ResultObject(KSUCCESS,"success");
			}
		}		
		return new ResultObject(KFAIL,"fial");
	}

	

	@Override
	@GET
	@Path("updateage/{userName},{age}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateUserAge(@PathParam("userName")String userName,@PathParam("age") int age) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null) {
			user.setAge(age);
			boolean result = userDAO.updateUser(user);
			if (result) {
				return new ResultObject(KSUCCESS,"success");
			}
		}
		return new ResultObject(KFAIL,"fial");
	}

	@Override
	@GET
	@Path("updatesex/{userName},{sex}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateUserSex(@PathParam("userName")String userName,@PathParam("sex") String sex) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null) {
			user.setSex(sex);
			boolean result = userDAO.updateUser(user);
			if (result) {
				return new ResultObject(KSUCCESS,"success");
			}
		}
		return new ResultObject(KFAIL,"fial");
	}
	
	@GET
	@Path("updatephotourl/{userName},{photourl}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateUserPhotoURL(@PathParam("userName")String userName,@PathParam("photourl") String photourl) {
		User user = userDAO.findUserByUserName(userName);
		if (user != null) {
			user.setPhotourl(photourl);
			boolean result = userDAO.updateUser(user);
			if (result) {
				return new ResultObject(KSUCCESS,"success");
			}
		}
		return new ResultObject(KFAIL,"fial");
	}


	/**
	 * 5.�޸��û�����
	 * ������userName �û���; password ����  
	 */
	@Override
	@GET
	@Path("updatepassword/{userName},{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultObject updateUserPwd(@PathParam("userName")String userName, @PathParam("password")String password) {
		boolean result = userDAO.updateUserPwd(userName, password);
		if (result) {
			return new ResultObject(KSUCCESS,"success");
		}
		return new ResultObject(KFAIL,"fial");
	}

	
	
	

	
	

}
