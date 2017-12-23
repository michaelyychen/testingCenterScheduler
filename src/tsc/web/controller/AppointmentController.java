package tsc.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.TypeUtils;

import tsc.web.bean.AppointmentBean;
import tsc.web.bean.ErrorBean;
import tsc.web.bean.ExamBean;
import tsc.web.bean.FeedBackBean;
import tsc.web.bean.JsonBean;
import tsc.web.bean.SeatBean;
import tsc.web.bean.UserBean;
import tsc.web.bean.request.ChangeAppointmentStatusRequestBean;
import tsc.web.bean.request.ChangeAppointmentStatusResponseBean;
import tsc.web.bean.request.CreateAppointmentRequestBean;
import tsc.web.bean.request.CreateAppointmentResponseBean;
import tsc.web.bean.request.HttpResponseBean;
import tsc.web.bean.request.ViewAppointmentRequestBean;
import tsc.web.bean.request.ViewAppointmentResponseBean;
import tsc.web.framework.Control;
import tsc.web.framework.Controller;
import tsc.web.service.AppointmentService;
import tsc.web.utils.Constants;
import tsc.web.utils.FunUtils;
import tsc.web.utils.MessageUtils;

@Control("/control/appointment")
public class AppointmentController implements Controller{

	AppointmentService mService = new AppointmentService();
	
	public static final String PAGE_ATTR_EXAMS = "exams";
	
	
	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void errorPage(HttpServletRequest request,
			HttpServletResponse response, String message) throws Exception {
		
		request.setAttribute("error", new ErrorBean(message));
		request.getRequestDispatcher("/error.jsp").forward(request, response);
		
	}
	

	public void goTomakeAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(!FunUtils.isLogin(request)){
			FunUtils.goToLoginPage(response);
			return;
		}
		
		UserBean user = FunUtils.getUser(request);
		List<ExamBean> exams = mService.getExams(user);
		request.setAttribute(PAGE_ATTR_EXAMS, exams);
		webPageResponse(request,response,"/makeAppointment.jsp");
		
	}

	public void makeAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(!FunUtils.isLogin(request)){
			FunUtils.goToLoginPage(response);
			return;
		}
		
		CreateAppointmentRequestBean requestBean = new CreateAppointmentRequestBean(request);
		if(requestBean.validData()){
			
			CreateAppointmentResponseBean responseBean = mService.createAppointment(requestBean);
			int result = responseBean.getResult();
			
			if(result== HttpResponseBean.SERVICE_SUCCESS){
				
				// Go to ....
				//webPageResponse(request, response, "/");
				
			}else{
				
				FeedBackBean feedBack = responseBean.getFeedback();
				errorPage(request, response,feedBack.getMessage());
				// Go to error page
			}
			
		}else{
			
			// go error page
		}
		
	}
	
	public void viewAppointments(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if(!FunUtils.isLogin(request)){
			FunUtils.goToLoginPage(response);
			return;
		}
		
		HttpSession session = request.getSession();
		Object sesseionObj =  session.getAttribute(UserController.SESSION_USER);
		if(sesseionObj instanceof UserBean){
				ViewAppointmentRequestBean requestBean = new ViewAppointmentRequestBean(request);
				
				UserBean user = (UserBean) sesseionObj;
				if(requestBean.validData()){
				ViewAppointmentResponseBean responseBean = mService.getAppointments(user, requestBean);
				if(responseBean.isSuccess()){
					
				}
				else{
					FeedBackBean feedBack = responseBean.getFeedback();
					errorPage(request, response, feedBack.getMessage());
				}
				}
		}
		
		
	}
	
	
	
	
	public void updateAppointment(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		if(!FunUtils.isLogin(request)){
			FunUtils.goToLoginPage(response);
			return;
		}
		
			UserBean user = FunUtils.getUser(request);
			if(user!=null){
				
				ChangeAppointmentStatusRequestBean requestBean = new ChangeAppointmentStatusRequestBean(request);
				ChangeAppointmentStatusResponseBean responseBean = mService.changeAppointmentStatus(requestBean,user);
				if(responseBean.isSuccess()){
					jsonDataResponse();
					//
				}else{
					FeedBackBean feedBack = responseBean.getFeedback();
					errorPage(request, response,feedBack.getMessage());
				}
			}else{
				errorPage(request, response, "Please Login.");
				
			}
	}
	
	
	
	public void getAvaSeats(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			
		
	
		PrintWriter out = null;
		int code = Constants.SUCCESS;
		String message = MessageUtils.MSG_SUCCESS;
		JsonBean json = new JsonBean(code, message, null);
		String result = null;
		try {
			int role = TypeUtils.castToInt(request.getParameter("role"));
			int exam = TypeUtils.castToInt(request.getParameter("exam"));
			List<SeatBean> seats = mService.getAvaSeats(exam, role);
			response.setContentType("text/json;charset=utf-8");
			out = response.getWriter();
			json.setData(seats);
			result = JSON.toJSONString(json);
			out.print(result);
		} catch (Exception e) {
			json = new JsonBean(Constants.ERROR_RUNTIME_EXCEPTION,
					MessageUtils.MSG_ERROR_RUNTIME, null);
			String str = JSON.toJSONString(json);
			out.print(str);
		
		} finally {
			out.flush();
			out.close();
		}
	}
	
	// 3
	public void checkInStudent(HttpServletRequest request, HttpServletResponse response){
		
	}
	// 8
	public void generateReport(HttpServletRequest request, HttpServletResponse response){
		
	}
	

	@Override
	public void jsonDataResponse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void webPageResponse(HttpServletRequest request, HttpServletResponse response,String path) throws Exception {
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	

}
