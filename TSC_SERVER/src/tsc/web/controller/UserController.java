package tsc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsc.web.bean.ErrorBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.LoginRequestBean;
import tsc.web.dao.impl.UserDataManager;
import tsc.web.framework.Control;
import tsc.web.framework.Controller;

@Control("/control/user")
public class UserController implements Controller{

	UserDataManager userDataManager = new UserDataManager();
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
	}
	
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		LoginRequestBean requestBean = new LoginRequestBean(request);
		
		if(requestBean.validData()){
			UserBean user = userDataManager.findUser(requestBean.getEmail(), requestBean.getUserId(),requestBean.getPassword());
			if(user==null){
				errorPage(request,response,"Can't Not Find This User");
			}else{
				request.setAttribute("user", user);
				request.getRequestDispatcher("/student.jsp").forward(request, response);
			}
		}else{
			errorPage(request,response,"Invalid Username Or Password");
		}
		
	
		
		
	}

	@Override
	public void errorPage(HttpServletRequest request,
			HttpServletResponse response, String message) throws Exception {
		request.setAttribute("error", new ErrorBean(message));
		request.getRequestDispatcher("/error.jsp").forward(request, response);
	}
	

	
}
