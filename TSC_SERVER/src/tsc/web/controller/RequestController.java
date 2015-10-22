package tsc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tsc.web.bean.ErrorBean;
import tsc.web.bean.request.CreateReqRequestBean;
import tsc.web.framework.Controller;

public class RequestController implements Controller {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorPage(HttpServletRequest request, HttpServletResponse response, String message) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("error", new ErrorBean(message));
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		
	}

	@Override
	public void webPageResponse() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void jsonDataResponse() {
		// TODO Auto-generated method stub
		
	}
	
	public void makeRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CreateReqRequestBean requestBean = new 
		
	}

}
