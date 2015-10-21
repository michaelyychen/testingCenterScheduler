package tsc.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tsc.web.bean.AppointmentBean;
import tsc.web.bean.FeedBackBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.CreateAppointmentRequestBean;
import tsc.web.bean.request.CreateAppointmentResponseBean;
import tsc.web.bean.request.HttpResponseBean;
import tsc.web.framework.Control;
import tsc.web.framework.Controller;
import tsc.web.service.AppointmentService;

@Control("/control/appointment")
public class AppointmentController implements Controller{

	AppointmentService mService = new AppointmentService();
	
	
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorPage(HttpServletRequest request,
			HttpServletResponse response, String message) throws Exception {
		
		
	}
	
	

	public void makeAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CreateAppointmentRequestBean requestBean = new CreateAppointmentRequestBean(request);
		if(requestBean.validData()){
			
			CreateAppointmentResponseBean responseBean = mService.createAppointment(requestBean);
			int result = responseBean.getResult();
			
			if(result== HttpResponseBean.SERVICE_SUCCESS){
				
				// Go to ....
				
			}else{
				
				FeedBackBean feedBack = responseBean.getFeedback();
				// Go to error page
			}
			
		}else{
			
			// go error page
		}
		
	}
	
	public void viewAppointments(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		Object sesseionObj =  session.getAttribute(UserController.SESSION_USER);
		if(sesseionObj instanceof UserBean){
			
				UserBean user = (UserBean) sesseionObj;
				List<AppointmentBean> appointments = mService.getAppointments(user);
		}
	}
	

}
