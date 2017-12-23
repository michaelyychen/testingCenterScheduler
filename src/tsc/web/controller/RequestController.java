package tsc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tsc.web.bean.ErrorBean;
import tsc.web.bean.FeedBackBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.ChangeAppointmentStatusRequestBean;
import tsc.web.bean.request.ChangeReqStatusRequestBean;
import tsc.web.bean.request.ChangeReqStatusResponseBean;
import tsc.web.bean.request.CreateReqRequestBean;
import tsc.web.bean.request.CreateReqResponseBean;
import tsc.web.bean.request.HttpResponseBean;
import tsc.web.bean.request.ViewReqRequestBean;
import tsc.web.bean.request.ViewReqResponseBean;
import tsc.web.framework.Controller;
import tsc.web.service.RequestService;
import tsc.web.utils.FunUtils;

public class RequestController implements Controller {

	RequestService service;

	public RequestController() {
		// TODO Auto-generated constructor stub
		service = new RequestService();
	}

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
	public void jsonDataResponse() {
		// TODO Auto-generated method stub

	}

	public void makeRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!FunUtils.isLogin(request)) {
			FunUtils.goToLoginPage(response);
			return;
		}

		CreateReqRequestBean requestBean = new CreateReqRequestBean(request);
		if (requestBean.validData()) {
			CreateReqResponseBean responseBean = service.addRequest(requestBean);

			if (responseBean.isSuccess()) {

				// Go to ....

			} else {

				FeedBackBean feedBack = responseBean.getFeedback();
				errorPage(request, response, feedBack.getMessage());
				// Go to error page
			}
		} else {

			// go error page
		}
	}


	public void viewRequests(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// HttpSession session = request.getSession();
		// Object sesseionObj =
		// session.getAttribute(UserController.SESSION_USER);
		// if(sesseionObj instanceof UserBean){
		// UserBean user = (UserBean) sesseionObj;
		// ViewReqRequestBean requestBean = new ViewReqRequestBean(request);
		// if(requestBean.validData()){
		//
		// }
		// }
		if (!FunUtils.isLogin(request)) {
			FunUtils.goToLoginPage(response);
			return;
		}

		ViewReqRequestBean resquestBean = new ViewReqRequestBean(request);
		if (resquestBean.validData()) {
			ViewReqResponseBean responseBean = service.getRequestList(resquestBean);
			if (responseBean.isSuccess()) {

			} else {
				FeedBackBean feedBack = responseBean.getFeedback();
				errorPage(request, response, feedBack.getMessage());
			}
		}

	}

	public void updateRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (!FunUtils.isLogin(request)) {
			FunUtils.goToLoginPage(response);
			return;
		}

		UserBean user = FunUtils.getUser(request);
		if (user != null) {
			ChangeReqStatusRequestBean requestBean = new ChangeReqStatusRequestBean(request);
			ChangeReqStatusResponseBean responseBean = service.changeRequestStatus(requestBean, user);
			if (responseBean.isSuccess()) {
				jsonDataResponse();
				//
			} else {
				FeedBackBean feedBack = responseBean.getFeedback();
				errorPage(request, response, feedBack.getMessage());
			}
		} else {
			errorPage(request, response, "Please Login.");

		}
	}

	@Override
	public void webPageResponse(HttpServletRequest request, HttpServletResponse response, String path)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
